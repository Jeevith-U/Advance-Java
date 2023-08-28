package edu.ty.bankaccount.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BankAccount {
	@Id
	private int id;
	
	private String accountNumber;
    private String bankName;
    private double balance;
    private String ifsc;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", bankName=" + bankName + ", balance="
				+ balance + "]";
	}
	
    
    
}
