package edu.tyss.OneToOneExample3.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Remote {
	
	@Id
	private int id;
	private String brand ;
	private double price ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
