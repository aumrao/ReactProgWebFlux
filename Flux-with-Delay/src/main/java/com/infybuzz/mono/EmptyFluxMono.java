package com.infybuzz.mono;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EmptyFluxMono {

	public static void main(String[] args) {
		/*
		 * Flux<?> emptyFlux = Flux.empty().log();
		 * 
		 * emptyFlux.subscribe(System.out::println);
		 */
		
		String str = null;
		
		//Mono<String> emptyMono = Mono.empty().log();
		
		Mono<String> emptyMono = Mono.justOrEmpty(str).log();
		
		emptyMono.subscribe(System.out::println);
	}

}
