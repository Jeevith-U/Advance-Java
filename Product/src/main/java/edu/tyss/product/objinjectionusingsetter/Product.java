package edu.tyss.product.objinjectionusingsetter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Product {
	
	private int prodId ;
	private String name ;
	private double price ;
	public int getProdId() {
		return prodId;
	}
	@Value(value = "101")
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getName() {
		return name;
	}
	
	@Value(value = "Vegitables")
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	
	@Value(value = "150.45")
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void display() {
		
		System.out.println(prodId);
		System.out.println(name);
		System.out.println(price);
	}
	
}
