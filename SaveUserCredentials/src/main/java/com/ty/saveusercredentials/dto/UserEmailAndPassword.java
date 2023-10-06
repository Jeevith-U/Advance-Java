package com.ty.saveusercredentials.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEmailAndPassword {
	
	@Id
	private String email ;
	private String password ;
	
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
	@Override
	public String toString() {
		return "UserEmailAndPassword [email=" + email + ", password=" + password + "]";
	}
	
}
