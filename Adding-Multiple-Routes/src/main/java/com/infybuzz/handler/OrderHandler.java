package com.infybuzz.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.infybuzz.pojo.Order;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class OrderHandler {
	
	public Mono<ServerResponse> getAll(ServerRequest serverRequest) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(
						Flux.just(
								new Order(1L, 100.0),
								new Order(2L, 200.0),
								new Order(3L, 300.0)),
						Order.class
						);
	}
	
	public Mono<ServerResponse> getOne(ServerRequest serverRequest) {
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(
						Mono.just(new Order(1L, 100.00)), Order.class);
	}

}
