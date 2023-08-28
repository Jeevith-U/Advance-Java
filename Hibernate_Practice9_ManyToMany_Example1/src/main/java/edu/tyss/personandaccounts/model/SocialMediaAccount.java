package edu.tyss.personandaccounts.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SocialMediaAccount {
	
	@Id
	private int id;
	private String name ;
	private int followers ;
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
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	
}
