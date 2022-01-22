package com.infybuzz.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class StreamToFlux {

	public static void main(String[] args) {
		List<String> list = Arrays.asList();
		
		Stream<String> stream = list.stream();
		
		Flux<String> stringFlux = Flux.fromStream(stream).log();
		
		stringFlux.subscribe(System.out::println);
	}

}
