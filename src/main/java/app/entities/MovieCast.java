package app.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class MovieCast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "cast_id")
    private int castId;

    private boolean adult;
    private int gender;

    @Column(name = "known_for_department")
    private String knownForDepartment;

    private String name;

    @Column(name = "original_name")
    private String originalName;

    private double popularity;

    @Column(name = "profile_path")
    private String profilePath;


    private String character;


    // Relations

    @ManyToOne
    private Movie movie;
}
