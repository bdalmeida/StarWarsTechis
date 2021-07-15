package com.starwars.StarWars.services;

import com.starwars.StarWars.document.Planeta;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlanetaService {
	
	Flux<Planeta> findAll();
	Mono<Planeta> findById(String id);
	Mono<Planeta> save(Planeta planeta);

}
