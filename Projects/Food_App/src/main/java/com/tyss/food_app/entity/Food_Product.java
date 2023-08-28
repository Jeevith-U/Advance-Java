package com.tyss.food_app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tyss.food_app.util.Availability;
import com.tyss.food_app.util.Type;

@Entity
public class Food_Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id ;
	private String name ;
	private Type type ;
	private String about ;
	private Availability availability ;
	private double price ;
	
	@ManyToOne
	@JoinColumn()
	private Menu menu ;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Food_Product [id=" + id + ", name=" + name + ", type=" + type + ", about=" + about + ", availability="
				+ availability + ", price=" + price + ", menu=" + menu + "]";
	}
	
	
}
