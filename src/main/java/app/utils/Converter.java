package app.utils;

import app.dto.GenreDTO;
import app.dto.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Converter {

    private final Map<Integer, Genre> genreCache = new ConcurrentHashMap<>();

    public Movie convertFromMovie(MovieDTO movieDTO) {
       Movie movie = Movie.builder()
                .id(movieDTO.getId())
                .title(movieDTO.getTitle())
                .originalTitle(movieDTO.getOriginalTitle())
                .originalLanguage(movieDTO.getOriginalLanguage())
                .popularity(movieDTO.getPopularity())
                .releaseDate(movieDTO.getReleaseDate())
                .runtime(movieDTO.getRuntime())
                .build();

        Set<Genre> genreEntities = new HashSet<>();
        if (movieDTO.getGenres() != null)   {
            for (GenreDTO dto : movieDTO.getGenres())   {
                Genre genre = genreCache.computeIfAbsent(dto.getId(), id -> new Genre(dto.getId(), dto.getName(), new HashSet<>()));
                genreEntities.add(genre);
                genre.getMovies().add(movie);
            }
        }
        movie.setGenresList(genreEntities);
        return movie;
    }

    public List<Movie> convertFromMovies(List<MovieDTO> movieDTOs) {
        return movieDTOs.stream()
                .map(this::convertFromMovie)
                .collect(Collectors.toList());
    }




}
