package edu.tyss.ManyToMany_Example1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int id;
	private String accoutType ;
	private double balance ;
	private String bank ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccoutType() {
		return accoutType;
	}
	public void setAccoutType(String accoutType) {
		this.accoutType = accoutType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
}
