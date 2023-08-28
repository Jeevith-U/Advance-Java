package edu.hibernate_assignment.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.tuple.UpdateTimestampGeneration;

@Entity
public class FoodOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private boolean status ;
	@CreationTimestamp
	private LocalDateTime orderCreatedTime ;
	@UpdateTimestamp
	private LocalDateTime orderDeliveryTime ;
	private String customerName ;
	private long contactNumber ;
	private double price ;
	
	@ManyToOne
	@JoinColumn(name = "foodorder_info")
	private Users users ;
	
	@OneToMany(mappedBy="foodOrder")
	private List<Items> itemList ;

	public int getId() {
		return id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDateTime getOrderCreatedTime() {
		return orderCreatedTime;
	}

	public LocalDateTime getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Items> getItemList() {
		return itemList;
	}

	public void setItemList(List<Items> itemList) {
		this.itemList = itemList;
	}
}
