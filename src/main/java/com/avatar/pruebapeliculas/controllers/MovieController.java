package com.avatar.pruebapeliculas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avatar.pruebapeliculas.models.dtos.MovieDto;
import com.avatar.pruebapeliculas.models.dtos.MovieSimpleDto;
import com.avatar.pruebapeliculas.services.interfaces.IMovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService service;

    @GetMapping
    public ResponseEntity<List<MovieSimpleDto>> getAllMovies() {
        return ResponseEntity.ok(service.getMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable String id) {
        return ResponseEntity.ok(service.getMovie(id));
    }
}
