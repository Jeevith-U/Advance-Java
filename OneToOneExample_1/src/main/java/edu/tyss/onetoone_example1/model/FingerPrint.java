package edu.tyss.onetoone_example1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FingerPrint {
	
	@Id
	private int id ;
	private int numberofPrint ;
	private String type ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberofPrint() {
		return numberofPrint;
	}
	public void setNumberofPrint(int numberofPrint) {
		this.numberofPrint = numberofPrint;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
