package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Movie {

    @Id
    @Column(name = "tmdb_id")
    private int id;

    @Column(name = "imdb_id")
    private String imdbId;

    private boolean adult;

    private String genres;

    private String homepage;


    @Column(name = "country")
    private List<String> originCountry;

    @Column(name = "original_language")
    private String originalLanguage;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(columnDefinition = "TEXT") //TODO se om TEXT er nødvendig
    private String overview;

    private double popularity;

    @Column(name = "release_date")
    private String releaseDate;

    private int revenue;
    private int runtime;
    private String status;
    private String tagline;
    private String title;


    // Relations

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Cast> castList  = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Crew> crewList  = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Builder.Default
    @EqualsAndHashCode.Exclude
    private Set<Genre> genresList  = new HashSet<>();

}
