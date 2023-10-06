package com.tyss.spring_foodapp.service;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dao.ItemDao;
import com.tyss.spring_foodapp.dto.FoodOder;
import com.tyss.spring_foodapp.dto.Item;
import com.tyss.spring_foodapp.util.Type;

@Component
@Scope(value = "prototype")
public class ItemService  {
	
	@Autowired
	private EntityManager entityManager ;
	
	@Autowired
	private ItemDao dao ;
	
	public Item saveItemervice(Item item) {
		
		return dao.saveItem(item);
	}

	
	public Item getItembyIdService(int id) {
		
		return dao.findItem(id);
	}

	
	public Item getItembyNameService(String name) {
		
		Query query = entityManager.createQuery("select s from Item s where s.name = ?1") ;
		
		return (Item)query.setParameter(1, name).getSingleResult() ;
		
	}

	public List<Item> getItemFoodOrderIdService(int id) {
		
		return entityManager.find(FoodOder.class, id).getListItems() ;
		
	}

	public Item getItembyTypeService(Type type) {
		
        Query query = entityManager.createQuery("select s from Item s where s.type = ?1") ;
		
		return (Item)query.setParameter(1, type).getSingleResult() ;
	}

}
