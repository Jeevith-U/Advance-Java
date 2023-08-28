package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.Item;

public interface ItemDao {
	
	public Item saveItem(Item item) ;
	
	public Item findItem(int id) ;
	
	public Item updateItem(Item item) ;
	
	public boolean deleteItem(int id) ;
	
	public String itemReview(String review) ;
}
