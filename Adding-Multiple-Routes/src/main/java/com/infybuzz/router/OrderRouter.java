package com.infybuzz.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.infybuzz.handler.OrderHandler;

@Component
public class OrderRouter {
	
	@Autowired
	OrderHandler orderHandler;

	@Bean
	public RouterFunction<ServerResponse> orderRoutes() {
		return RouterFunctions
				.route(RequestPredicates.GET("/api/order/getAll"), 
						orderHandler::getAll)
				.andRoute(RequestPredicates.GET("/api/order/getOne"), 
						orderHandler::getOne);
	}
}
