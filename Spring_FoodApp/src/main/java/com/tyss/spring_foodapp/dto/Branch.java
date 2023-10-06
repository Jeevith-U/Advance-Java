package com.tyss.spring_foodapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = "prototype")
public class Branch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name ;
	private String address ;
	private String email ;
	private long phno ;
	
	@ManyToOne
	@JoinColumn
	private Users users ;

	public int getId() {
		return id;
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

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Branch [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phno=" + phno
				+ ", users=" + users + "]";
	}
	
	
}
