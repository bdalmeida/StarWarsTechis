package com.starwars.StarWars.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.starwars.StarWars.document.Planeta;

import reactor.core.publisher.Mono;

public interface PlanetaRepository extends ReactiveMongoRepository<Planeta, String> {

}
