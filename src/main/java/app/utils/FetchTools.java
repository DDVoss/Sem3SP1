package app.utils;

import app.dto.SearchResultDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FetchTools {

    /*
    public static ActivityDTO buildActivity(
            String cityName,
            ActivityType activityType,
            double distance, double duration,
            LocalTime timeOfDay,
            String comment,
            ExecutorService executor
    ) throws ExecutionException, InterruptedException {


        Future<WeatherInfoDTO> weatherInfoFuture;
        Future<CityInfoDTO> cityInfoFuture;

        weatherInfoFuture = executor.submit(() -> WeatherService.fetchWeatherDataByLocationName(cityName));
        cityInfoFuture = executor.submit(() -> CityService.getCityInfo(cityName));

        CityInfoDTO cityInfo = cityInfoFuture.get();
        WeatherInfoDTO weatherInfo = weatherInfoFuture.get();

        ActivityDTO activityDTO = ActivityDTO
                .builder()
                .exerciseType(activityType)
                .cityInfo(cityInfo)
                .distance(distance)
                .exerciseDate(LocalDate.now())
                .duration(duration)
                .timeOfDay(timeOfDay)
                .comment(comment)
                .weatherInfo(weatherInfo)
                .build();


        return activityDTO;
    }

     */

    public <T> T getFromApi(String uri, Class<T> dtoClass)  {
        ObjectMapper objectMapper = new ObjectMapper();

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
                return objectMapper.readValue(response.body(), dtoClass);
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> getFromApiList(String uri, Class<T> dtoClass)  {
        ObjectMapper objectMapper = new ObjectMapper();

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
                String json = response.body();
                SearchResultDTO<T> searchResult = objectMapper.readValue(json, objectMapper.getTypeFactory().constructParametricType(SearchResultDTO.class, dtoClass));
                return searchResult.getResults();
            } else {
                System.out.println("GET request failed. Status code: " + response.statusCode());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return List.of();
    }

}
