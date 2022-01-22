package com.infybuzz.flux;

import com.infybuzz.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ImmediateScheduler {

	public static void main(String[] args) {
		
		System.out.println("Started with - " + 
		Thread.currentThread().getName());
		
		Flux<Order> orderFlux = Flux.just(
				new Order(1L, 100.0),
				new Order(2L, 200.0),
				new Order(3L, 300.0)
				);
		
		Flux<Long> fluxLong = orderFlux
				.publishOn(Schedulers.immediate())
				.map(order -> {
					System.out.println("Map with - " + 
				Thread.currentThread().getName());
					return order.getId();
				});
		
		fluxLong.subscribe(orderId -> System.out.println("Sub with - " + 
		Thread.currentThread().getName()));
	}

}
