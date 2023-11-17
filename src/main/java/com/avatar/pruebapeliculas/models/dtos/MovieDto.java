package com.avatar.pruebapeliculas.models.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private String title;
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private LocalDate releaseDate;
    private String url;
    private List<CharacterMovieDto> characters;
}
