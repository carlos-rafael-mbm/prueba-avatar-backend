package com.avatar.pruebapeliculas.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("episode_id")
    private int episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private LocalDate releaseDate;

    @JsonProperty("characters")
    private List<String> charactersUrl;

    @JsonProperty("planets")
    private List<String> planetsUrl;

    @JsonProperty("starships")
    private List<String> starshipsUrl;

    @JsonProperty("vehicles")
    private List<String> vehiclesUrl;

    @JsonProperty("species")
    private List<String> speciesUrl;

    @JsonProperty("created")
    private LocalDateTime created;

    @JsonProperty("edited")
    private LocalDateTime edited;

    @JsonProperty("url")
    private String url;
}
