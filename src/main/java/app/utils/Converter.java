package app.utils;

import app.dto.GenreDTO;
import app.dto.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class Converter {


    // Convert MovieDTO to Movie entity, linking genres using the provided genreMap
    public Movie movieDtoToEntity(MovieDTO movieDTO, Map<Integer, Genre> genreMap) {
        Movie movie = Movie.builder()
                .id(movieDTO.getId())
                .title(movieDTO.getTitle())
                .originalTitle(movieDTO.getOriginalTitle())
                .originalLanguage(movieDTO.getOriginalLanguage())
                .popularity(movieDTO.getPopularity())
                .releaseDate(movieDTO.getReleaseDate())
                .runtime(movieDTO.getRuntime())
                .build();

        // Link genres to the movie using the genreMap. If a genre ID from the DTO exists in the map, add the corresponding Genre entity to the movie.
        if (movieDTO.getGenreIds() != null)   {
            for (Integer gDto : movieDTO.getGenreIds())  {
                Genre genre = genreMap.get(gDto);
                if (genre != null)  {
                    movie.addGenre(genre);
                }
            }
        }
        return movie;
    }

    // Convert a list of MovieDTOs to a list of Movie entities
    public List<Movie> movieCollectList(List<MovieDTO> movieDTOs, Map<Integer, Genre> genreMap) {
        return movieDTOs.stream()
                .map(dto -> movieDtoToEntity(dto, genreMap))
                .collect(Collectors.toList());
    }

    // Convert GenreDTO to Genre entity
    public Genre genreDtoToEntity(GenreDTO genreDTO)    {
        return Genre.builder()
                .id(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
    }

    // Convert a list of GenreDTOs to a list of Genre entities
    public List<Genre> genreCollectList(List<GenreDTO> genreDTOS) {
        return genreDTOS.stream()
                .map(this::genreDtoToEntity)
                .collect(Collectors.toList());
    }




}
