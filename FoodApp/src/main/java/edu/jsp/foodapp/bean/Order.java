package edu.jsp.foodapp.bean;

import java.io.Serializable;

public class Order implements Serializable{
	
	private int orderId ;
	private String orderName ;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + "]";
	}
	
	
}
