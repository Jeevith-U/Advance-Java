package com.tyss.food_app.serviceimplementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Item;
import com.tyss.food_app.service.ItemService;
import com.tyss.food_app.userDaoImplementation.ItemDaoImplementation;
import com.tyss.food_app.util.EntityUtil;
import com.tyss.food_app.util.Type;

public class ItemServiceImplementation implements ItemService {
	
	EntityUtil entityUtil = new EntityUtil() ;
	
	ItemDaoImplementation dao = new ItemDaoImplementation() ;
	
	public Item saveItemervice(Item item) {
		
		return dao.saveItem(item);
	}

	
	public Item getItembyIdService(int id) {
		
		return dao.findItem(id);
	}

	
	public Item getItembyNameService(String name) {
		
		Query query = entityUtil.manager.createQuery("select s from Item s where s.name = ?1") ;
		
		return (Item)query.setParameter(1, name).getSingleResult() ;
		
	}

	public List<Item> getItemFoodOrderIdService(int id) {
		
		return entityUtil.manager.find(FoodOder.class, id).getListItems() ;
		
	}

	public Item getItembyTypeService(Type type) {
		
        Query query = entityUtil.manager.createQuery("select s from Item s where s.type = ?1") ;
		
		return (Item)query.setParameter(1, type).getSingleResult() ;
	}

}
