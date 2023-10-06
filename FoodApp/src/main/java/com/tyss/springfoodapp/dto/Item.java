package com.tyss.springfoodapp.dto;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.springfoodapp.util.Type;

@Component
@Entity
@Scope(value = "prototype")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private int productId ;
	private String name ;
	private int quantity ;
	private double price ;
	private Type type ;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", productId=" + productId + ", name=" + name + ", quantity=" + quantity + ", price="
				+ price + "]";
	}
	
	
}
