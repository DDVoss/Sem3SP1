package app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class MovieDTO {
    private int id;

    private String title;

    @JsonProperty("genre_ids")
    private List<Integer> genreIds;

    @JsonProperty("original_title")
    private String originalTitle;

    @JsonProperty("origin_country")
    private List<String> originCountry;

    @JsonProperty("original_language")
    private String originalLanguage;

    private double popularity;

    @JsonProperty("release_date")
    private String releaseDate;

    private int runtime;


}

