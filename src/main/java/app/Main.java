package app;

import app.config.HibernateConfig;
import app.dao.MovieDAO;
import app.dto.MovieDTO;
import app.entities.Movie;
import app.services.MovieService;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        MovieDAO movieDAO = new MovieDAO(emf);

        System.out.println("Hello, World!");

        MovieService movieService = new MovieService();

        MovieDTO output = movieService.getMovieById("134");
        System.out.println(output);


        List<Movie> allMovies = movieService.getLatestDanishMovie();
        allMovies.forEach(movieDAO::create);

        //allMovies.forEach(m -> System.out.println(m.getOriginalTitle()));



    }
}