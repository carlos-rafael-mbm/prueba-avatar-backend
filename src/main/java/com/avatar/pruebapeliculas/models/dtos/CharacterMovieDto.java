package com.avatar.pruebapeliculas.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterMovieDto {
    private String name;
    private String height;
    private String mass;
}
