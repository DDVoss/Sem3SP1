package app.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Cast {

    @Id
    @Column(name = "cast_id")
    private int id;

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

    @Column(name = "cast_id")
    private int castId;

    private String character;


    // Relations

    @ManyToOne
    private Movie movie;
}
