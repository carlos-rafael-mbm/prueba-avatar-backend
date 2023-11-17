package com.avatar.pruebapeliculas.models.dtos;

import java.util.List;

import com.avatar.pruebapeliculas.models.entities.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    private Object next;

    @JsonProperty("previous")
    private Object previous;

    @JsonProperty("results")
    private List<Movie> movies;
}
