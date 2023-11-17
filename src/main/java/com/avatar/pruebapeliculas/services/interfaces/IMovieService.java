package com.avatar.pruebapeliculas.services.interfaces;

import java.util.List;

import com.avatar.pruebapeliculas.models.dtos.MovieDto;
import com.avatar.pruebapeliculas.models.dtos.MovieSimpleDto;

public interface IMovieService {
    List<MovieSimpleDto> getMovies();
    MovieDto getMovie(String id);
}
