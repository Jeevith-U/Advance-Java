package edu.tyss.aadharandperson.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aadhar {
	 @Id
	private int id ;
	private long aadharNumber ;
	private String fullName ;
	private String permanentAddress ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public Aadhar() {
		super();
	}
	public Aadhar(int id, long aadharNumber, String fullName, String permanentAddress) {
		super();
		this.id = id;
		this.aadharNumber = aadharNumber;
		this.fullName = fullName;
		this.permanentAddress = permanentAddress;
	}
	@Override
	public String toString() {
		return "Aadhar [id=" + id + ", aadharNumber=" + aadharNumber + ", fullName=" + fullName + ", permanentAddress="
				+ permanentAddress + "]";
	}
	
	
	
}
