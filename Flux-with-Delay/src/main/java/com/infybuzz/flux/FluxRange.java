package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FluxRange {

	public static void main(String[] args) {
		
		Flux<Integer> intFlux = Flux.range(5, 1);
		
		intFlux.subscribe(System.out::println);
	}

}
