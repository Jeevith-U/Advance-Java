package edu.tyss.mto_otm_bideirection.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	
	@Id
	private int AccountNumber;
	private String accountType ;
	private double saving ;
	
	@ManyToOne
	@JoinColumn(name = "bank_accountInfo")
	private Bank bank;

	public int getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getPrice() {
		return saving;
	}

	public void setPrice(double price) {
		this.saving = price;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
