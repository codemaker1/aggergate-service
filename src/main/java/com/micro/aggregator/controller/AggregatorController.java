package com.micro.aggregator.controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.micro.aggregator.bean.Orders;
import com.micro.aggregator.bean.User;
import com.micro.aggregator.bean.UserOrders;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Produces(MediaType.APPLICATION_JSON)
public class AggregatorController {
	
	
	/*
	 * @Bean public RestTemplate resTemplate(RestTemplateBuilder builder) { return
	 * builder.build(); }
	 */
	//@Resource(name="restTemp")
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserServiceProxy userProxy;
	
	@Autowired
	private OrdersServieProxy ordersProxy;
	
	@GetMapping("/check")
	public String check()
	{
		return "ok";
	}
	
	@GetMapping("/orderdetails/{id}")
	@HystrixCommand(fallbackMethod = "userOrdersFallBack")
	public UserOrders getUser(@PathVariable int id)
	{
	  UserOrders userOrders = new UserOrders();
	  
	 //String url = 
	  
	//  User user = restTemplate.getForObject(url, User.class);
	 // ResponseEntity<User> response = restTemplate.exchange(url+"/user"+id, HttpMethod.GET, null, User.class);
	//  User user = response.getBody();
	 // User user = restTemplate.getForObject(url, User.class);
	 //User user = restTemplate.getForObject("http://localhost:8080/user/"+id, User.class);
	 User user =  userProxy.retrieveUserValue(id);
	  
	  //Orders[] orders =  restTemplate.getForObject("http://orders-service/orders/"+id, Orders[].class);
	 List<Orders> orders = ordersProxy.retrieveOrdersValue(id);
	 // List<Orders> ordersList=Arrays.asList(orders);
	  userOrders.setUserDetails(user);
	 userOrders.setOrders(orders);
	  return userOrders;
		
	}
	
	public UserOrders userOrdersFallBack(int id)
	{
		return new UserOrders();
	}

}
