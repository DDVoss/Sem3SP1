package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "movies")

public class Movie {

    @Id
    @Column(name = "tmdb_id")
    private int id;

    private String title;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "original_language")
    private String originalLanguage;

    private double popularity;

    @Column(name = "release_date")
    private String releaseDate;

    private int runtime;


    // Relations

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<MovieCast> movieCastList = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Crew> crewList  = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genresList = new HashSet<>();

}

