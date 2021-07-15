package com.starwars.StarWars.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.starwars.StarWars.document.Planeta;
import com.starwars.StarWars.repository.PlanetaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlanetaServiceImpl implements PlanetaService {
	
	@Autowired
	PlanetaRepository pr;

	@Override
	public Flux<Planeta> findAll() {
		return pr.findAll();
	}

	@Override
	public Mono<Planeta> findById(String id) {
		return pr.findById(id);
	}

	@Override
	public Mono<Planeta> save(Planeta planeta) {
		return pr.save(planeta);
	}

}
