package edu.tyss.manytoone.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	private int id ;
	private int cost ;
	private String name ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product(int id, int cost, String name) {
		super();
		this.id = id;
		this.cost = cost;
		this.name = name;
	}
	
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", cost=" + cost + ", name=" + name + "]";
	}
	
	
}
