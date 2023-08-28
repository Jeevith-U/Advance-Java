package edu.tyss.hibernate_practice7.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	private long id ;
	private String name ;
	private String email ;
	private String phno ;
	
	@OneToMany
	private List<Cart> orders ;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public List<Cart> getOrders() {
		return orders;
	}

	public void setOrders(List<Cart> orders) {
		this.orders = orders;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phno=" + phno + ", orders=" + orders
				+ "]";
	}
	
}
