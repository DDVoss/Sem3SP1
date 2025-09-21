package app.utils;

import app.dto.GenreResponseDTO;
import app.dto.SearchResultDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class FetchTools {

    ObjectMapper objectMapper = new ObjectMapper();

    // Generic method to fetch data from an API and map it to a specified DTO class
    public <T> T getFromApi(String uri, Class<T> dtoClass)  {

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                    .newBuilder()
                    .header("accept", "application/json")
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200)   {
                // Map the JSON response to the specified DTO class
                return objectMapper.readValue(response.body(), dtoClass);
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    // Method to handle paginated API responses and aggregate results into a list of specified DTO class
    public <T> List<T> getFromApiListWithPages(String uri, Class<T> dtoClass)  {
        List<T> allResults = new ArrayList<>();


        try {
            HttpClient client = HttpClient.newHttpClient();

            // Start with the first page
            int page = 1;
            int totalPages;
            
            do {
                String urlWithPage = uri + "&page=" + page;

                HttpRequest request = HttpRequest
                        .newBuilder()
                        .header("accept", "application/json")
                        .uri(new URI(urlWithPage))
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 200) {
                    String json = response.body();
                    // Generics are erased so we use TypeFactory.constructParametricType to specify which generic type we want for SearchResultDTO
                    SearchResultDTO<T> searchResult = objectMapper.readValue(
                            json,
                            objectMapper.getTypeFactory()
                                    .constructParametricType(SearchResultDTO.class, dtoClass));

                    allResults.addAll(searchResult.getResults());

                    totalPages = searchResult.getTotal_pages();
                    page++;

                } else {
                    System.out.println("GET request failed. Status code: " + response.statusCode());
                    break;
                }
                // Continue until all pages are fetched
            } while (page <= totalPages);

        } catch (Exception e){
            e.printStackTrace();
        }
        return allResults;
    }



}
