package edu.tyss.firstlevel_caching.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	@CreationTimestamp
	private LocalDateTime ManufacturedDate ;
	private double price ;
	
	@ManyToOne
	@JoinColumn(name = "User_info")
	private Users users ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getManufacturedDate() {
		return ManufacturedDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users users) {
		this.users = users;
	}
	
}
