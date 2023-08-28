package edu.tyss.onetoone_example4.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegistrastionDetails {
	
	@Id
	private int id;
	private String name;
	private String ownerShip ;
	
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
	public String getOwnerShip() {
		return ownerShip;
	}
	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}
	
}
