package com.tyss.spring_foodapp.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = "prototype")
public class FoodOder {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String status ;
	private double totalPrice ;
	@CreationTimestamp
	private LocalDateTime createTime ;
	@UpdateTimestamp
	private LocalDateTime orderDeliverdTime ;
	private String customerName ;
	private long customerPhoneNumber ;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> listItems ;
	
	@ManyToOne
	@JoinColumn(name = "FoodOrder_Info")
	private Users users ;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getOrderDeliverdTime() {
		return orderDeliverdTime;
	}

	public void setOrderDeliverdTime(LocalDateTime orderDeliverdTime) {
		this.orderDeliverdTime = orderDeliverdTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(long customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public List<Item> getListItems() {
		return listItems;
	}

	public void setListItems(List<Item> listItems) {
		this.listItems = listItems;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FoodOder [id=" + id + ", status=" + status + ", totalPrice=" + totalPrice + ", createTime=" + createTime
				+ ", orderDeliverdTime=" + orderDeliverdTime + ", customerName=" + customerName
				+ ", customerPhoneNumber=" + customerPhoneNumber + ", listItems=" + listItems + ", users=" + users
				+ "]";
	}
	
	
}
