package com.starwars.StarWars;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class PlanetaRouter {

//	@Bean
	public RouterFunction<ServerResponse> route(PlanetaHandler handler){
		return RouterFunctions
				.route(GET("/planeta").and(accept(MediaType.APPLICATION_JSON)),handler::findAll)
				.andRoute(GET("/planeta/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::findById)
				.andRoute(POST("/planeta").and(accept(MediaType.APPLICATION_JSON)), handler::save);
	}
}
