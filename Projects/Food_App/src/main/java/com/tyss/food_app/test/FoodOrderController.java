package com.tyss.food_app.test;

import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.userDaoImplementation.FoodOrderImplementation;
import com.tyss.food_app.userDaoImplementation.Food_ProductDaoImplementation;
import com.tyss.food_app.util.Availability;
import com.tyss.food_app.util.Type;

public class FoodOrderController {
	
	public static void main(String[] args) {
		
		Food_Product product = new Food_Product() ;
//		
		  Food_ProductDaoImplementation dao = new Food_ProductDaoImplementation() ;
//		
//		product.setAvailability(Availability.AVAILABLE);
//		product.setName("Biriyani");
//		product.setPrice(220);
//		product.setType(Type.NONVEG);
		
//		dao.saveFoodProduct(product) ;
		
		Food_Product p = dao.findFoodProduct(6) ;
		System.out.println(p);
		  
		  p.setName("oooo");
	}
}
