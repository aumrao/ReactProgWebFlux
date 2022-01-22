package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class FirstFlux {

	public static void main(String[] args) {
		Flux<String> stringFlux = Flux.just("John", "Raj", "Sachin")
				.concatWith(Flux.error(new RuntimeException()))
				.concatWith(Flux.just("Peter")).log();
		
		stringFlux.subscribe(System.out::println, 
				e -> System.out.println("Exception"),
				() -> System.out.println("Success"));
	}

}
