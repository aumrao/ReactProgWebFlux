package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FluxFilter {

	public static void main(String[] args) {
		Flux<String> stringFlux = Flux.just("John", "Raj", "Sachin")
				.filter(s -> s.length() > 3)
				.log();
		
		stringFlux.subscribe(System.out::println);
	}

}
