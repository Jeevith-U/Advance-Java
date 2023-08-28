package edu.svit.customeranditem.model;

import java.util.List;

public class Customer {
	
	private int id ;
	private String name ;
	private long phoneNumber ;
	private String address ;
	
	private List<Item> listofItems;

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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Item> getListofItems() {
		return listofItems;
	}

	public void setListofItems(List<Item> listofItems) {
		this.listofItems = listofItems;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", listofItems=" + listofItems + "]";
	}

	public Customer() {
		super();
	} 
	
	
}
