package app.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Crew {
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

    @Column(name = "credit_id")
    private String creditId;

    private String department;
    private String job;
}
