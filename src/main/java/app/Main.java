package app;

import app.dto.MovieDTO;
import app.services.MovieService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MovieDTO movieDTO = new MovieDTO();
        MovieService movieService = new MovieService();

        MovieDTO output = movieService.getMovieById("134");

        List<MovieDTO> allMovies = movieService.getLatestDanishMovie();
        System.out.println("Fetched: " + allMovies.size());
        allMovies.forEach(m -> System.out.println(m.getCurrentData().getOriginalTitle()));

    }
}