package com.infybuzz.flux;

import org.reactivestreams.Subscription;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

public class BackPressureExample {

	public static void main(String[] args) {
		Flux<Integer> intFlux = Flux.range(1, 10).log();
		
		/*
		 * intFlux.subscribe(System.out::println, ex -> ex.printStackTrace(), () ->
		 * System.out.println("Completed"));
		 */
		
		intFlux.subscribe(new BaseSubscriber<Integer>() {
			
			protected void hookOnSubscribe(Subscription subscription){
				subscription.request(5);
			}
			
			protected void hookOnNext(Integer value){
				if(value == 3) {
					cancel();
				}
				System.out.println(value);
			}
			
			protected void hookOnComplete() {
				System.out.println("Completed");
			}
			
			protected void hookOnError(Throwable throwable) {
				throwable.printStackTrace();
			}
			
		});
		
	}

}
