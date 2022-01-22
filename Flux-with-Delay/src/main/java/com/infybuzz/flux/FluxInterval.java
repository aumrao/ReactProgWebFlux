package com.infybuzz.flux;

import java.time.Duration;

import reactor.core.publisher.Flux;

public class FluxInterval {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Started with - " + 
				Thread.currentThread().getName());
		
		Flux<Long> fluxLong = Flux.just(1L, 2L, 3L).
				delayElements(Duration.ofSeconds(1));
		
		fluxLong.subscribe(value
				-> System.out.println("Sub with - " + Thread.currentThread().getName()));
		
		Thread.sleep(4000);
	}

}
