package app.services;

import app.dto.MovieDTO;
import app.entities.Movie;
import app.utils.Converter;
import app.utils.FetchTools;


import java.util.List;

public class MovieService {


    String apiKey = System.getenv("API_KEY");
    FetchTools apiReader = new FetchTools();
    Converter converter = new Converter();

    public MovieDTO getMovieById(String id) {

        String movieURL = "https://api.themoviedb.org/3/movie/";

        String url = new String(movieURL + id + "?api_key=" + apiKey);

        try {
            return apiReader.getFromApi(url, MovieDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Movie> getLatestDanishMovie()   {

        String movieURL = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&page=1&primary_release_date.gte=2024-09-15&primary_release_date.lte=2025-09-15&region=dk&sort_by=primary_release_date.desc&with_original_language=da";

        String url = new String(movieURL + "&api_key=" + apiKey);

        try {
            List<MovieDTO> dtoList = apiReader.getFromApiList(url , MovieDTO.class);
            return converter.convertFromMovies(dtoList);

        } catch (Exception e)    {
            throw new  RuntimeException(e);
        }
    }
}
