package edu.tyss.oneToMany_Example1.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Phone {
	
	@Id
	private int id;
	private String name ;
	private double price ;
	
	@OneToMany
	private List<Sim> sims ;

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

	public List<Sim> getSims() {
		return sims;
	}

	public void setSims(List<Sim> sims) {
		this.sims = sims;
	}
	
}
