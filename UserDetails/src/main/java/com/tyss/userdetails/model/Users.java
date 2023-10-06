package com.tyss.userdetails.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private String email ;
	private String password ;
	private double balance ;
	
	@CreationTimestamp
	private LocalDateTime createdTime ;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Flight> flightList ;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Accommodation> accommodationList ;
	
	public String getName() {
		return name;
	}
	@Value(value = "jeevith")
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	@Value(value = "jee@vich.com")
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	@Value(value = "Jee@VICH22")
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	
	public List<Flight> getFlightList() {
		return flightList;
	}
	
	public void setFlightList(List<Flight> flightList) {
		this.flightList = flightList;
	}
	public List<Accommodation> getAccommodationList() {
		return accommodationList;
	}
	public void setAccommodationList(List<Accommodation> accommodationList) {
		this.accommodationList = accommodationList;
	}
	public double getBalance() {
		return balance;
	}
	
	@Value(value = "230000")
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	
}
