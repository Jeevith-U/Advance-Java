package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Item;

public interface FoodOrder {
	
	public FoodOder saveFoodOrder(FoodOder oder) ;
	
	public FoodOder findFoodOrder(int id) ;
	
	public FoodOder upadateFoodOrder(FoodOder oder) ;
	
	public boolean deleteFoodOrder(int id) ;
	
	public FoodOder trackFoodOrder(FoodOder foodOder) ;
	
	public FoodOder addItemToPresentOrder(int id ,Item item) ;

}
