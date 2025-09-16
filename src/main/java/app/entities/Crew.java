package app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Crew {

    @Id
    @Column(name = "crew_id")
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

    private String department;
    private String job;
}
