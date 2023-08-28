package edu.hibernate_assignment.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "Id_geneator")
	@SequenceGenerator(name = "Id_geneator", initialValue = 10,allocationSize = 10, sequenceName = "seq_id_gen")
	@Column(name = "User_Id")
	private int id ;
	private String name ;
	@Column(unique = true)
	private String email ;
	@Column(nullable = false, unique = true)
	private String password ;
	private String role ;
	
	@OneToOne(mappedBy = "users")
	private Menu menu ;
	
	@OneToMany(mappedBy = "users")
	private List<Branch> branchList ;
	
	@OneToMany(mappedBy = "users")
	private List<FoodOrder> listOfOrder ;

	public int getId() {
		return id;
	}

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

	public void setRole(String r) {
		this.role = r;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Branch> getBranchList() {
		return branchList;
	}

	public void setBranchList(List<Branch> branchList) {
		this.branchList = branchList;
	}

	public List<FoodOrder> getListOfOrder() {
		return listOfOrder;
	}

	public void setListOfOrder(List<FoodOrder> listOfOrder) {
		this.listOfOrder = listOfOrder;
	}
	
}
