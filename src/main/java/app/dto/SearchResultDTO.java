package app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResultDTO<T> {
    private int page;
    private List<T> results;
    private int total_results;
    private int total_pages;
}
