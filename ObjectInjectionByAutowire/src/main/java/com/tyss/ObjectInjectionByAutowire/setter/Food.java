package com.tyss.ObjectInjectionByAutowire.setter;

import org.springframework.stereotype.Component;

@Component
public class Food {
	
	int foodId = 661568 ;
	String foodName = "Bisi bele Bath" ;
	double price = 40 ;
	String branchName = "Jaynagar" ;
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", branchName=" + branchName
				+ "]";
	}
	
	

}
