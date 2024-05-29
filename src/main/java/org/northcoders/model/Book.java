package org.northcoders.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(String id, String title, String author, String genre, String description) {
}
