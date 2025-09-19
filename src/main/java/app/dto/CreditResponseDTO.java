package app.dto;

import app.entities.Cast;
import app.entities.Crew;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class CreditResponseDTO {
    private int id;                   // movie id
    private List<CastDTO> cast;     // cast list
    //private List<Crew> crew;     // crew list
}
