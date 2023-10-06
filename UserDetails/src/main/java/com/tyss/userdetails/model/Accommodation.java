package com.tyss.userdetails.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="prototype")
@Entity
public class Accommodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@SequenceGenerator(name = "idgen", initialValue = 13424, allocationSize = 213, sequenceName = "accommdationseqid")
	private int id ;
	private String name ;
	private String Origin ;
	private int stayDays ;
	private double price ;
	
	@ManyToOne
	@JoinColumn(name = "userAccommodation")
	private Users users ;
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getName() {
		return name;
	}
	@Value(value = "Provident Doral At the Blue")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOrigin() {
		return Origin;
	}
	
	@Value(value = "India")
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public int getStayDays() {
		return stayDays;
	}
	
	@Value(value = "10")
	public void setStayDays(int stayDays) {
		this.stayDays = stayDays;
	}
	public double getPrice() {
		return price;
	}
	
	@Value(value = "120000")
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	
}
