package edu.hibernate_assignment.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	
	@OneToMany(mappedBy = "menu")
	List<Food_Product> foodProductList ;
	
	@ManyToOne
	@JoinColumn(name = "menu_info")
	private Users users ;

	public int getId() {
		return id;
	}

	public List<Food_Product> getFoodProductList() {
		return foodProductList;
	}

	public void setFoodProductList(List<Food_Product> foodProductList) {
		this.foodProductList = foodProductList;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
