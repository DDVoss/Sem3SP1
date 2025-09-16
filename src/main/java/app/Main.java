package app;

import app.dto.MovieDTO;
import app.services.MovieService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        MovieDTO movieDTO = new MovieDTO();
        MovieService movieService = new MovieService();

        MovieDTO output = movieService.getMovieById("134");

        System.out.println(output);
    }
}