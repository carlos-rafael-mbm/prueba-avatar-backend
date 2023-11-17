package com.avatar.pruebapeliculas.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.avatar.pruebapeliculas.models.dtos.CharacterMovieDto;
import com.avatar.pruebapeliculas.models.dtos.MovieDto;
import com.avatar.pruebapeliculas.models.dtos.MovieResponse;
import com.avatar.pruebapeliculas.models.dtos.MovieSimpleDto;
import com.avatar.pruebapeliculas.models.entities.CharacterMovie;
import com.avatar.pruebapeliculas.models.entities.Movie;
import com.avatar.pruebapeliculas.services.interfaces.IMovieService;

@Service
public class MovieService implements IMovieService {

    @Value("${externalapi.url}")
    private String externalApiUrl;
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<MovieSimpleDto> getMovies() {
        List<Movie> movies = webClientBuilder
                                .build()
                                .get()
                                .uri(externalApiUrl)
                                .retrieve()
                                .bodyToMono(MovieResponse.class)
                                .block()
                                .getMovies();

        return movies.stream().map(movie -> mapper.map(movie, MovieSimpleDto.class)).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovie(String id) {
        WebClient webClient = webClientBuilder.build();
        Movie movie = webClient
                        .get()
                        .uri(externalApiUrl + "/" + id)
                        .retrieve()
                        .bodyToMono(Movie.class)
                        .block();
        List<CharacterMovie> characters = movie.getCharactersUrl().stream()
            .map(characterUrl -> webClient.get()
                    .uri(characterUrl)
                    .retrieve()
                    .bodyToMono(CharacterMovie.class)
                    .block())
            .collect(Collectors.toList());
        List<CharacterMovieDto> characterDtos = characters.stream().map(character -> mapper.map(character, CharacterMovieDto.class)).collect(Collectors.toList());
        MovieDto movieDto = mapper.map(movie, MovieDto.class);
        movieDto.setCharacters(characterDtos);
        return movieDto;
    }
    
}
