package com.infybuzz.flux;

import com.infybuzz.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ParallelScheduler {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Started with - " + 
		Thread.currentThread().getName());
		
		Flux<Order> orderFlux = Flux.just(
				new Order(1L, 100.0),
				new Order(2L, 200.0),
				new Order(3L, 300.0)
				);
		
		Flux<Long> fluxLong = orderFlux
				.publishOn(Schedulers.newParallel("my-parallel"))
				.map(order -> {
					System.out.println("Map 1 with - " + 
				Thread.currentThread().getName());
					return order.getId();
				})
				.publishOn(Schedulers.newParallel("my-parallel"))
				.map(order -> {
					System.out.println("Map 2 with - " + 
				Thread.currentThread().getName());
					return order * 2;
				});
		
		fluxLong.subscribe(orderId -> System.out.println("Sub with - " + 
		Thread.currentThread().getName()));
		
		Thread.sleep(3000);
	}

}
