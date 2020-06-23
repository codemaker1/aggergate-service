package com.micro.aggregator.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.aggregator.bean.Orders;


@FeignClient(name="orders-service", url="${ORDERS_URI:http://localhost}:8100")
public interface OrdersServieProxy {
	
	@GetMapping("/orders/{id}")
	public List<Orders> retrieveOrdersValue(@PathVariable int id);

}
