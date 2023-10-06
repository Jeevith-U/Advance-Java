package com.tyss.spring_foodapp.service;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dao.FoodOrderDao;
import com.tyss.spring_foodapp.dto.FoodOder;
import com.tyss.spring_foodapp.dto.Item;

@Component
@Scope(value = "prototype")
public class FoodOrderService {
	
	@Autowired
	private FoodOrderDao dao ;
	
	@Autowired
	private EntityManager entityManager ;

	
	public FoodOder saveFoodOder(FoodOder order) {
		
		return dao.saveFoodOrder(order);
	}

	
	public FoodOder updateFoodOder(FoodOder order) {
		
		return dao.upadateFoodOrder(order);
	}

	
	public boolean deleteFoodOder(int id) {
		
		return dao.deleteFoodOrder(id);
	}

	
	public FoodOder getFoodOderbyIdService(int id) {
		
		return dao.findFoodOrder(id);
	}

	
	public FoodOder getFoodOderbyCustomerNameService(String name) {
		
		Query query  = (Query) entityManager.createQuery("select f from FoodOder f where f.customername = ?1 ") ;
		
		return (FoodOder)((javax.persistence.Query) query).setParameter(1, name).getSingleResult() ;
	}

	
	public FoodOder getFoodOderbyCustomerPhoneNumberService(long ph) {
		
        javax.persistence.Query query  = entityManager.createQuery("select f from FoodOder f where f.customerphonenumber = ?1 ") ;
		
		return (FoodOder)query.setParameter(1, ph).getSingleResult() ;
	}

	public double gettotalPriceofFoodOrder(int id) {
		
		FoodOder order = entityManager.find(FoodOder.class, id) ;
		
		double totalPrice = 0 ;
		
		for(Item item : order.getListItems()) {
			
			totalPrice += item.getPrice() ;
		}
		return totalPrice;
	}


	
	public int getNonvegItemServiice(int id) {
		
		int count = 0 ;
		
		List<Item> items = entityManager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("NONVEG")) 
				count++ ;
		}
		
		return count;
	}


	
	public int getBVegItemServiice(int id) {
		
        int count = 0 ;
		
		List<Item> items = entityManager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("VEG")) 
				count++ ;
		}
		
		return count;
	}


	
	public int getVeganItemServiice(int id) {
		
        int count = 0 ;
		
		List<Item> items = entityManager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("VEGAN")) 
				count++ ;
		}
		
		return count;
	}


	public List<FoodOder> getAllFoodOrderService() {
		
		javax.persistence.Query query = entityManager.createQuery("from FoodOder");
		return query.getResultList() ;
		 
	}


}
