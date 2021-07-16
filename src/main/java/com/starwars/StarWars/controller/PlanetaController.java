package com.starwars.StarWars.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.StarWars.document.Planeta;
import com.starwars.StarWars.services.PlanetaService;

import java.time.Duration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import java.util.concurrent.TimeUnit;

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
	
	@GetMapping(value="/planeta/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Planeta>> getPlanetaByEvents(){

		//System.out.println("---Start get Playlists by WEBFLUX--- " + LocalDateTime.now());
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
		Flux<Planeta> events = service.findAll();
		System.out.println("Passou aqui");
		return Flux.zip(interval, events);
		
        
	}
	
	
}
