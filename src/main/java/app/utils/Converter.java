package app.utils;

import app.dto.CastDTO;
import app.dto.GenreDTO;
import app.dto.MovieDTO;
import app.entities.Cast;
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


    public Cast creditDtoToEntity(CastDTO castDTO) {
        Cast cast = Cast.builder()

                .id(castDTO.getId())
                .adult(castDTO.isAdult())
                .gender(castDTO.getGender())
                .knownForDepartment(castDTO.getKnownForDepartment())
                .name(castDTO.getName())
                .originalName(castDTO.getOriginalName())
                .popularity(castDTO.getPopularity())
                .profilePath(castDTO.getProfilePath())
                .castId(castDTO.getCastId())
                .character(castDTO.getCharacter())
                .creditId(castDTO.getCreditId())
                .order(castDTO.getOrder())
                .build();
        return cast;
    }

    public List<Cast> creditDtoToEntity(List<CastDTO> castDTOs) {
        return castDTOs.stream()
                .map(this::creditDtoToEntity)
                .collect(Collectors.toList());
    }
}
