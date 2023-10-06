package com.tyss.food_application.Model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = "prototype")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private String email ;
	private String password ;
	private String role ;
	public int getId() {
		return id;
	}
	
	
	@OneToOne
	private Menu menu ;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Branch> branch ;
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<FoodOder> foodOrderList ;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Branch> getBranch() {
		return branch;
	}

	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	public List<FoodOder> getFoodOrderList() {
		return foodOrderList;
	}

	public void setFoodOrderList(List<FoodOder> foodOrderList) {
		this.foodOrderList = foodOrderList;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", menu=" + menu + ", branch=" + branch + ", foodOrderList=" + foodOrderList + "]";
	}
	
}
