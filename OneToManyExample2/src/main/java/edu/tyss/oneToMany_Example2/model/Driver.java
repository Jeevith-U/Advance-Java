package edu.tyss.oneToMany_Example2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {
	
	@Id
	private int id ;
	private String name;
	private double price ;
	private double distance ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
}
