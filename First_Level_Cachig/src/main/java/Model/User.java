package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	private int id ;
	private String name ;
	
	@OneToOne
	private UserProduct product ;
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
	public UserProduct getProduct() {
		return product;
	}
	public void setProduct(UserProduct product) {
		this.product = product;
	}
	
}
