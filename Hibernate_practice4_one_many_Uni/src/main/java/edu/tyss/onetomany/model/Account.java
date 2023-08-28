package edu.tyss.onetomany.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	private int aid ;
	private long anumber ;
	private double abalance ;
	
	public int getId() {
		return aid;
	}
	public void setId(int id) {
		this.aid = id;
	}
	public long getNumber() {
		return anumber;
	}
	public void setNumber(long number) {
		this.anumber = number;
	}
	public double getBalance() {
		return abalance;
	}
	public void setBalance(double balance) {
		this.abalance = balance;
	}
	public Account() {
		super();
	}
	public Account(int id, long number, double balance) {
		super();
		this.aid = id;
		this.anumber = number;
		this.abalance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + aid + ", number=" + anumber + ", balance=" + abalance + "]";
	}
	
	
}
