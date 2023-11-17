package com.avatar.pruebapeliculas;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class PruebapeliculasApplication {

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(PruebapeliculasApplication.class, args);
	}

}
