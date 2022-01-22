package com.infybuzz.flux;

import reactor.core.publisher.Flux;

public class ArrayToFlux {

	public static void main(String[] args) {
		String[] array = new String[] {"John", "Raj", "Peter"};
		
		Flux<String> stringFlux = Flux.fromArray(array).log();
		
		stringFlux.subscribe(System.out::println);
	}

}
