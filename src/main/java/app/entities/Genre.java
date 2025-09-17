package app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Genre {

    @Id
    @Column(name = "genre_id")
    private int id;

    private String name;

    // Relations

    @ManyToMany(mappedBy = "genresList")
    private Set<Movie> movies = new HashSet<>();

    public void addMovie(Movie movie)   {
        this.movies.add(movie);
        movie.getGenresList().add(this);
    }

}
