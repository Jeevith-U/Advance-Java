package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.Food_Product;

public interface Food_ProductDao {
	
	public Food_Product saveFoodProduct(Food_Product Product) ;
	
	public Food_Product findFoodProduct(int id) ;
	
	public Food_Product updateFoodProduct(Food_Product Product) ;
	
	public boolean deleteFoodProduct(int id) ;
}
