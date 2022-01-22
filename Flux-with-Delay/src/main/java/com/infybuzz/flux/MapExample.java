package com.infybuzz.flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.infybuzz.pojo.Order;

public class MapExample {

	public static void main(String[] args) {
		List<Order> list = Arrays.asList(
				new Order(1L, 100.0),
				new Order(2L, 200.0),
				new Order(3L, 300.0));
		
		List<Long> longList = list.stream()
				.filter(order -> order.getAmount() > 100.0)
				.map(order -> {
					System.out.println("Inside Map");
					return order.getId();
				})
				.collect(Collectors.toList());
		
		longList.forEach(System.out::println);
	}

}
