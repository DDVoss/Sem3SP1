package app;

import app.config.HibernateConfig;
import app.dao.GenreDAO;
import app.dao.MovieDAO;
import app.dto.GenreDTO;
import app.dto.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;
import app.services.MovieService;
import app.utils.Converter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        MovieDAO movieDAO = new MovieDAO(emf);
        GenreDAO genreDAO = new GenreDAO(emf);
        MovieService movieService = new MovieService();

        System.out.println("Ready, set, GO! ===>");


        List<Genre> allGenres = movieService.getAllGenre();
        allGenres.forEach(genreDAO::create);

        Map<Integer, Genre> genreMap = allGenres.stream()
                .collect(Collectors.toMap(Genre::getId, g -> g));

        List<MovieDTO> movieDTOs = movieService.getLatestDanishMovieDTOs();
        List<Movie> allMovies = new Converter().movieCollectList(movieDTOs, genreMap);
        allMovies.forEach(movieDAO::create);


        //allMovies.forEach(m -> System.out.println(m.getOriginalTitle()));



        emf.close();


    }
}