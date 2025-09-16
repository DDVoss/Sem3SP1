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

    @JsonProperty("imdb_id")
    private String imdbId;

    @JsonUnwrapped   // 👈 tells Jackson to map root fields into this object
    private CurrentData currentData;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentData {
        private boolean adult;
        private List<GenreDTO> genres;
        private String homepage;

        @JsonProperty("origin_country")
        private List<String> originCountry;

        @JsonProperty("original_language")
        private String originalLanguage;

        @JsonProperty("original_title")
        private String originalTitle;

        private String overview;
        private double popularity;

        @JsonProperty("release_date")
        private String releaseDate;

        private int revenue;
        private int runtime;
        private String status;
        private String tagline;
        private String title;
    }
}

