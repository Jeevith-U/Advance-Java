package edu.tyss.hibernate_practice7.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
	
	@Id
	private long id;
	private String orderNumber ;
	private double totalPrice ;
	private int numberOfItems ;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public Cart() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", totalPrice=" + totalPrice + ", numberOfItems="
				+ numberOfItems + "]";
	}
	
}
