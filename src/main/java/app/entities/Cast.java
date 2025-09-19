package app.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "casts")
@Builder

public class Cast {

    @Id
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

    @Column(name = "credit_id")
    private String creditId;

    @Column(name = "cast_order")
    private int order;


    // Relations

}
