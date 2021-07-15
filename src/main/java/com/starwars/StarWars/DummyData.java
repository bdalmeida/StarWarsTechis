package com.starwars.StarWars;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.starwars.StarWars.repository.PlanetaRepository;
import com.starwars.StarWars.document.Planeta;

import reactor.core.publisher.Flux;

//@Component
//public class DummyData implements CommandLineRunner{
//	
//private final PlanetaRepository planetaRepository;
//	
//    DummyData(PlanetaRepository planetaRepository) {
//        this.planetaRepository = planetaRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    	planetaRepository.deleteAll()
//                .thenMany(
//                        Flux.just("Planeta001", "Planeta002", "Planeta003",
//                                "Planeta004", "Planeta005", "Planeta005", "Planeta006")
//                                .map(nome -> new Planeta(UUID.randomUUID().toString(), nome))
//                                .flatMap(planetaRepository::save))
//                .subscribe(System.out::println);
//    }
//
//}
