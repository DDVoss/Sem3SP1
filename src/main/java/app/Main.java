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

        List<MovieDTO> output1 = movieService.getLatestDanishMovie();

        output1.forEach(System.out::println);
    }
}