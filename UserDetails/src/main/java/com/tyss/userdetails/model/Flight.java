package com.tyss.userdetails.model;

import javax.annotation.processing.Generated;
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
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idgen")
	@SequenceGenerator(name = "idgen", initialValue = 100, allocationSize = 22, sequenceName = "flightseqid" )
	private int id ;
	private String name ;
	private double price ;
	private String destination ;
	
	@ManyToOne
	@JoinColumn(name = "flightUser")
	private Users users ;
	public String getName() {
		return name;
	}
	@Value(value = "AirIndia")
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	
	@Value(value = "120302.310")
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDestination() {
		return destination;
	}
	
	@Value(value = "Miami")
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", name=" + name + ", price=" + price + ", destination=" + destination + "]";
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
}
