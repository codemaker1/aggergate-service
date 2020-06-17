package com.micro.aggregator.bean;

public class Orders {

	int orderId ;
	
	int orderAmount;
	
	String orderDate;
	
	int userId;
	
	public Orders() {
		super();
	}

	public Orders(int orderAmount, String orderDate, int userId) {
		super();
		this.orderAmount = orderAmount;
		this.orderDate = orderDate;
		this.userId = userId;
	}
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate + ", userId="
				+ userId + "]";
	}

	
	
	
	

}
