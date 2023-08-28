package edu.tyss.empandcompany.mode;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employe {
	
	@Id
	private int id ;
	private String name ;
	private String email ;
	private String password ;
	private long phno ;
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
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	public Employe() {
		super();
	}
	public Employe(int id, String name, String email, String password, long phno) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phno = phno;
	}
	@Override
	public String toString() {
		return "Employe [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phno=" + phno
				+ "]";
	}
	
	
}
