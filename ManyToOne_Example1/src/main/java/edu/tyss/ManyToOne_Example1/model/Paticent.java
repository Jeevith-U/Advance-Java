package edu.tyss.ManyToOne_Example1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paticent {
	
	@Id
	private int id ;
	private String name ;
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
	
}
