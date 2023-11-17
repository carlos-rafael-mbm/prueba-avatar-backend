package com.avatar.pruebapeliculas.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterMovie {
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("height")
    private String height;

    @JsonProperty("mass")
    private String mass;
}
