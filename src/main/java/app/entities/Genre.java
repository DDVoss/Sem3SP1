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

public class Genre {

    @Id
    @Column(name = "genre_id")
    private int id;

    private String name;

    // Relations
    @ManyToOne
    private Movie movie;

}
