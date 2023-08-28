package edu.tyss.firstlevel_caching.model;

import java.util.List;
import java.util.jar.Attributes.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Users {
	
	@Id
	@Column(name ="Users_id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", initialValue = 10, allocationSize = 10, sequenceName = "Id_strategy") 
	private int id ;
	
	@Column(unique = true)
	private long phno ;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "users")
	@Cascade(CascadeType.ALL)
	private List<Products> productList ;

	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}


	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Products> getProductList() {
		return productList;
	}

	public void setProductList(List<Products> productList) {
		this.productList = productList;
	}
	
}
