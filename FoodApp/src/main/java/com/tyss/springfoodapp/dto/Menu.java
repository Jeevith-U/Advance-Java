package com.tyss.springfoodapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Entity
@Scope(value = "prototype")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id" )
	@SequenceGenerator(name = "menu_id", initialValue = 10, allocationSize = 10, sequenceName = "sequence_menu")
	private int id ;
	
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<Food_Product> productList ;
	
	@OneToOne
	private Users users;

	public List<Food_Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Food_Product> productList) {
		this.productList = productList;
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
		return "Menu [id=" + id + ", productList=" + productList + ", users=" + users + "]";
	}
	
	
}
