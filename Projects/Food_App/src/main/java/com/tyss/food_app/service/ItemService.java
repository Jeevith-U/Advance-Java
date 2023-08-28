package com.tyss.food_app.service;

import java.util.List;

import com.tyss.food_app.entity.Item;
import com.tyss.food_app.util.Type;

public interface ItemService {
	
	public Item saveItemervice (Item item) ;
	public Item getItembyIdService (int id) ;
	public Item getItembyNameService (String name) ;
	public Item getItembyTypeService (Type type) ;
	public List<Item> getItemFoodOrderIdService (int id) ;
}
