package com.infybuzz.flux;

import com.infybuzz.pojo.Order;

import reactor.core.publisher.Flux;

public class FluxMap {

	public static void main(String[] args) {
		Flux<Order> orderFlux = Flux.just(
				new Order(1L, 100.0),
				new Order(2L, 200.0),
				new Order(3L, 300.0)
				);
		
		Flux<Long> fluxLong = orderFlux
				.filter(order -> order.getAmount() > 100.0)
				.map(order -> {
					System.out.println("Inside Map");
					return order.getId();
				});
		
		fluxLong.subscribe(System.out::println);
	}

}
