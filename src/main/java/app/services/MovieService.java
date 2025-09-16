package app.services;

import app.dto.MovieDTO;
import app.utils.FetchTools;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieService {
    //TODO URI for getting the latest danish film from 2018-09-15 to 2025-09-15
//          curl --request GET \
//          --url 'https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&page=1&primary_release_date.gte=2018-09-15&primary_release_date.lte=2025-09-15&region=dk&sort_by=primary_release_date.desc&with_original_language=da' \
//          --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJhZDhlZWY5NThmOTQxZjc5NzIwN2FjN2M3Nzg4ZGM4OCIsIm5iZiI6MTc1NzQ1MDc5Ni4zOTgwMDAyLCJzdWIiOiI2OGMwOTIyYzc2MThiZDM1YzExYmQ0MjIiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.5M6yN-ZGmZoh_UwAmTVaoausax2NWqk5RrU2Wdlw_eE' \
//          --header 'accept: application/json'

    String apiKey = System.getenv("API_KEY");
    String movieURL = "https://api.themoviedb.org/3/movie/";
    FetchTools apiReader = new FetchTools();

    public MovieDTO getMovieById(String id) {

        String url = new String(movieURL + id + "?api_key=" + apiKey);

        try {
            return apiReader.getFromApi(url, MovieDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public get
}
