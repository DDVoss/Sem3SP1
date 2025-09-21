package app.services;

import app.dto.GenreDTO;
import app.dto.GenreResponseDTO;
import app.dto.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;
import app.utils.Converter;
import app.utils.FetchTools;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MovieService {

    String apiKey = System.getenv("API_KEY");
    FetchTools apiReader = new FetchTools();
    Converter converter = new Converter();

    // Get movie by ID. Not necessarily used, but was a gateway to understand how the API works
    public MovieDTO getMovieById(String id) {

        String movieURL = "https://api.themoviedb.org/3/movie/";

        String url = new String(movieURL + id + "?api_key=" + apiKey);

        try {
            return apiReader.getFromApi(url, MovieDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Get latest Danish movies released between 2024-09-15 and 2025-09-15
    public List<MovieDTO> getLatestDanishMovieDTOs() {
        String movieURL = "https://api.themoviedb.org/3/discover/movie"
                + "?include_adult=false&include_video=false"
                + "&primary_release_date.gte=2024-09-15"
                + "&primary_release_date.lte=2025-09-15"
                + "&region=dk"
                + "&sort_by=primary_release_date.desc"
                + "&with_original_language=da"
                + "&api_key=" + apiKey;

        try {
            // Using a utility method to handle pagination and fetch all pages of results. The API uses pagination for large result sets.
            return apiReader.getFromApiListWithPages(movieURL, MovieDTO.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Genre> getAllGenre()    {
        String genreURL = "https://api.themoviedb.org/3/genre/movie/list?language=en" + "&api_key=" + apiKey;

        try {
            // Fetch the genre list from the API
            GenreResponseDTO genreList = apiReader.getFromApi(genreURL, GenreResponseDTO.class);
            return genreList.getGenres();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
