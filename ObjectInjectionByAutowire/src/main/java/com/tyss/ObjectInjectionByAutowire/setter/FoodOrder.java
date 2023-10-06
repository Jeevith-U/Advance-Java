package com.tyss.ObjectInjectionByAutowire.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodOrder {
	
	Food food ;
	
	String customerName = "Jeevith" ;
	
	@Autowired
	public void setFood(Food food) {
		this.food = food;
	}

	@Override
	public String toString() {
		return "FoodOrder [food=" + food + ", customerName=" + customerName + "]";
	}
	
	
}
