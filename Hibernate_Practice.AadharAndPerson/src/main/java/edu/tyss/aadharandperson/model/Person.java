package edu.tyss.aadharandperson.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	
	@Id
	private int id ;
	private String name ;
	private String addres ;
	private long phno ;
	private int picode ;
	
	@OneToOne
	private Aadhar aadhar ;

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

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public int getPicode() {
		return picode;
	}

	public void setPicode(int picode) {
		this.picode = picode;
	}

	public Aadhar getAadhar() {
		return aadhar;
	}

	public void setAadhar(Aadhar aadhar) {
		this.aadhar = aadhar;
	}

	public Person() {
		super();
	}

	public Person(int id, String name, String addres, long phno, int picode, Aadhar aadhar) {
		super();
		this.id = id;
		this.name = name;
		this.addres = addres;
		this.phno = phno;
		this.picode = picode;
		this.aadhar = aadhar;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", addres=" + addres + ", phno=" + phno + ", picode=" + picode
				+ ", aadhar=" + aadhar + "]";
	}
	
	
}
