package edu.tyss.manytoone.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Reviews {
	
	@Id
	private int id ;
	private String heading ;
	private String message ;
	
	@ManyToOne
	private Product product ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Reviews(int id, String heading, String message, Product product) {
		super();
		this.id = id;
		this.heading = heading;
		this.message = message;
		this.product = product;
	}
	
	
	public Reviews() {
		super();
	}

	@Override
	public String toString() {
		return "Reviews [id=" + id + ", heading=" + heading + ", message=" + message + ", product=" + product + "]";
	}
	
	
}
