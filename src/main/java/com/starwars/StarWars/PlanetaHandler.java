package com.starwars.StarWars;



import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.starwars.StarWars.document.Planeta;
import com.starwars.StarWars.services.PlanetaService;

import reactor.core.publisher.Mono;

@Component
public class PlanetaHandler {
	
	@Autowired
	PlanetaService service;
	
	public Mono<ServerResponse> findAll(ServerRequest request){
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Planeta.class);				
	}
	

	public Mono<ServerResponse> findById(ServerRequest request){
		String id = request.pathVariable("id");
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id), Planeta.class);				
	}
	
	public Mono<ServerResponse> save(ServerRequest request){
		final Mono<Planeta> planeta = request.bodyToMono(Planeta.class);
		return ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromPublisher(planeta.flatMap(service::save), Planeta.class));
	}
	
	
}
