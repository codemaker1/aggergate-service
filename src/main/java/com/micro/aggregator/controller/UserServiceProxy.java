package com.micro.aggregator.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.aggregator.bean.User;

@FeignClient(name="user-service", url="${USER_URI:http://localhost}:8080")
public interface UserServiceProxy {
	
	@GetMapping("/user/{id}")
	public User retrieveUserValue(@PathVariable int id);

}
