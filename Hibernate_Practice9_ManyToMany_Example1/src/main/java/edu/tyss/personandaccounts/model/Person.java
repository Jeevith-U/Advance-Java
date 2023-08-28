package edu.tyss.personandaccounts.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person {
	
	@Id
	private int id ;
	private String name ;
	private long phno ;
	
	@ManyToMany
	private List<SocialMediaAccount> accounts ;

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

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public List<SocialMediaAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<SocialMediaAccount> accounts) {
		this.accounts = accounts;
	}
	
}
