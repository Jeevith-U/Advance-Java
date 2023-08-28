package edu.tyss.oneToMany_Example4.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	private int id ;
	private int UserNuber ;
	private String userDevice ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserNuber() {
		return UserNuber;
	}
	public void setUserNuber(int userNuber) {
		UserNuber = userNuber;
	}
	public String getUserDevice() {
		return userDevice;
	}
	public void setUserDevice(String userDevice) {
		this.userDevice = userDevice;
	}
	
	
}
