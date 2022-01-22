package com.infybuzz.mono;

import java.util.Optional;

import reactor.core.publisher.Mono;

public class OptionalToMono {

	public static void main(String[] args) {
		//Optional<String> optional = Optional.of("John");
		
		//Optional<String> optional = Optional.empty();
		
		Optional<String> optional = null;
		
		Mono<String> stringMono = Mono.justOrEmpty(optional).log();
		
		stringMono.subscribe(System.out::println);
	}

}
