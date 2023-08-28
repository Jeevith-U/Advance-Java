package com.tyss.food_app.test;

import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.userDaoImplementation.Food_ProductDaoImplementation;
import com.tyss.food_app.util.Availability;
import com.tyss.food_app.util.Type;

public class FoodproductContoller {
	
	public static void main(String[] args) {
		
		Food_ProductDaoImplementation dao = new Food_ProductDaoImplementation() ;
		
//		Food_Product product = new Food_Product() ;
//		
//		product.setAbout("made of rice and masala");
//		product.setAvailability(Availability.AVAILABLE);
//		product.setName("Rice Bath");
//		product.setPrice(40);
//		product.setType(Type.VEGAN);
//		
//		dao.saveFoodProduct(product) ;
		
		Food_Product product = dao.findFoodProduct(3) ;
		
		product.setAvailability(Availability.NOT_AVAILABLE);
		
		dao.updateFoodProduct(product) ;
		
		dao.deleteFoodProduct(3) ;
		
	}
}
