package com.micro.aggregator.bean;

import java.util.List;

public class UserOrders {

	User userDetails;
	
	List<Orders> orders;
	

	public UserOrders() {
		super();
	}


	public UserOrders(User userDetails, List<Orders> orders) {
		super();
		this.userDetails = userDetails;
		this.orders = orders;
	}



	public User getUserDetails() {
		return userDetails;
	}


	public void setUserDetails(User userDetails) {
		this.userDetails = userDetails;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "UserOrders [userDetails=" + userDetails + ", orders=" + orders + "]";
	}

	
	
	
	
}
