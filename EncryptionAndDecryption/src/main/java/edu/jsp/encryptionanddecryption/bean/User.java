package edu.jsp.encryptionanddecryption.bean;

import java.io.Serializable;

public class User implements Serializable {
	
	private int id ;
	private String Name ;
	private String email ;
	private String password  ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
