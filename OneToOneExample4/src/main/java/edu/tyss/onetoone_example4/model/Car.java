package edu.tyss.onetoone_example4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	private String carNumber;
	private double price ;
	private String color ;
	
	@OneToOne
	private RegistrastionDetails details ;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public RegistrastionDetails getDetails() {
		return details;
	}

	public void setDetails(RegistrastionDetails details) {
		this.details = details;
	}
	
}
