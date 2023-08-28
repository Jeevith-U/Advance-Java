package edu.jsp.foodandrestorent.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int customerId ;
	private String customerName ;
	private String adderss ;
	private long phno ;
	private List<Items> itemsList ;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}
	public Customer() {
		super();
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", adderss=" + adderss + ", phno=" + phno + ", items=" 
				+ "]";
	}
	
	
}
