package edu.tyss.OneToOneExample2.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IdCard {
	
	@Id
	private int id ;
	private String name ;
	private String IdType ;
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
	public String getIdType() {
		return IdType;
	}
	public void setIdType(String idType) {
		IdType = idType;
	} 
	
}
