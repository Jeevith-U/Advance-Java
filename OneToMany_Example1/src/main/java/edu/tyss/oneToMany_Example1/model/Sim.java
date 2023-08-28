package edu.tyss.oneToMany_Example1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sim {
	
	@Id
	private int id;
	private String name ;
	private long number;
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
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	
	
}
