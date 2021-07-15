package com.starwars.StarWars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.StarWars.document.Planeta;
import com.starwars.StarWars.services.PlanetaService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PlanetaController {
	
	@Autowired
	PlanetaService service;
	
	@GetMapping(value="/planeta")
	public Flux<Planeta> getPlaneta(){
		return service.findAll();
	}
	
	@GetMapping(value="/planeta/{id}")
	public Mono<Planeta> getPlanetaId(@PathVariable String id){
		return service.findById(id);
	}
	
	@PostMapping(value="/planeta")
	public Mono<Planeta> save (@RequestBody Planeta planeta){
		return service.save(planeta);
	}
}
