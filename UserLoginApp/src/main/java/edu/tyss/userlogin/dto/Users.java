package edu.tyss.userlogin.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(value = "prototype")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id")
	@SequenceGenerator(name = "id", initialValue = 100, allocationSize = 26, sequenceName = "seqid")
	private int id ;
	private String name ;
	private String email ;
	private String password ;
	private String phno ;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phno=" + phno
				+ "]";
	}
	
}
