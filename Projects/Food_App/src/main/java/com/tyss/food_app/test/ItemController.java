package com.tyss.food_app.test;

import com.tyss.food_app.entity.Item;
import com.tyss.food_app.userDaoImplementation.ItemDaoImplementation;

public class ItemController {
	
	public static void main(String[] args) {
		
//		Item item = new Item() ;
//		
		ItemDaoImplementation dao = new ItemDaoImplementation() ;
//		
//		item.setName("baaathuu");
//		item.setPrice(220);
//		item.setProductId(212);
//		item.setQuantity(2);
//		
//		dao.saveItem(item) ;
		
		Item item = dao.findItem(5) ;
		System.out.println(item);
		
		item.setName("test Update");
		
		dao.updateItem(item) ;
	}
}
