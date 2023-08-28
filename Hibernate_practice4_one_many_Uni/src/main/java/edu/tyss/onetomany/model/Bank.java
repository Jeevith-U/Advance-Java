package edu.tyss.onetomany.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bank {
	
	@Id
	private int id ;
	private String name ;
	private String ifsc ;
	
	@OneToMany
	private List<Account> listOfAccounts ;

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

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public List<Account> getAccounts() {
		return listOfAccounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.listOfAccounts = accounts;
	}

	public Bank() {
		super();
	}

	public Bank(int id, String name, String ifsc, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.ifsc = ifsc;
		this.listOfAccounts = accounts;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", name=" + name + ", ifsc=" + ifsc + ", accounts=" + listOfAccounts + "]";
	}
	
	
}
