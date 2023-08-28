package edu.tyss.hibernate_practice.one_one_uni.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	private int id;
	private String name ;
	private double price ;
	
	@OneToOne
	private Engine engine ;

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

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Car(int id, String name, double price, Engine engine) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.engine = engine;
	}

	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", engine=" + engine + "]";
	}
	
	
	
}
