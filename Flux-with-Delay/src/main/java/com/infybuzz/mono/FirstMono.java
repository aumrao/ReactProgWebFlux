package com.infybuzz.mono;

import reactor.core.publisher.Mono;

public class FirstMono {

	public static void main(String[] args) {
		//Mono<String> stringMono = Mono.just("John").log();
		
		Mono<Object> stringMono = Mono.error(new RuntimeException()).log();
		
		stringMono.subscribe(System.out::println);
	}

}
