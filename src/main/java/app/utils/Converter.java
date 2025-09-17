package app.utils;

import app.dto.GenreDTO;
import app.dto.MovieDTO;
import app.entities.Genre;
import app.entities.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class Converter {


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

        if (movieDTO.getGenres() != null)   {
            for (GenreDTO gDto : movieDTO.getGenres())  {
                Genre genre = genreMap.get(gDto.getId());
                if (genre != null)  {
                    movie.addGenre(genre);
                }
            }
        }
        return movie;
    }

    public List<Movie> movieCollectList(List<MovieDTO> movieDTOs, Map<Integer, Genre> genreMap) {
        return movieDTOs.stream()
                .map(dto -> movieDtoToEntity(dto, genreMap))
                .collect(Collectors.toList());
    }

    public Genre genreDtoToEntity(GenreDTO genreDTO)    {
        return Genre.builder()
                .id(genreDTO.getId())
                .name(genreDTO.getName())
                .build();
    }
    public List<Genre> genreCollectList(List<GenreDTO> genreDTOS) {
        return genreDTOS.stream()
                .map(this::genreDtoToEntity)
                .collect(Collectors.toList());
    }




}
