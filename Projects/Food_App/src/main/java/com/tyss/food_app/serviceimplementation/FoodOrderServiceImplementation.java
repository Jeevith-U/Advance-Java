package com.tyss.food_app.serviceimplementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Item;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.service.FoodOrderService;
import com.tyss.food_app.userDaoImplementation.FoodOrderImplementation;
import com.tyss.food_app.util.EntityUtil;

public class FoodOrderServiceImplementation implements FoodOrderService{
	
	EntityUtil entityUtil = new EntityUtil() ;
	
	FoodOrderImplementation dao = new FoodOrderImplementation() ;

	
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
		
		Query query  = entityUtil.manager.createQuery("select f from FoodOder f where f.customername = ?1 ") ;
		
		return (FoodOder)query.setParameter(1, name).getSingleResult() ;
	}

	
	public FoodOder getFoodOderbyCustomerPhoneNumberService(long ph) {
		
        Query query  = entityUtil.manager.createQuery("select f from FoodOder f where f.customerphonenumber = ?1 ") ;
		
		return (FoodOder)query.setParameter(1, ph).getSingleResult() ;
	}

	public double gettotalPriceofFoodOrder(int id) {
		
		FoodOder order = entityUtil.manager.find(FoodOder.class, id) ;
		
		double totalPrice = 0 ;
		
		for(Item item : order.getListItems()) {
			
			totalPrice += item.getPrice() ;
		}
		return totalPrice;
	}


	
	public int getNonvegItemServiice(int id) {
		
		int count = 0 ;
		
		List<Item> items = entityUtil.manager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("NONVEG")) 
				count++ ;
		}
		
		return count;
	}


	
	public int getBVegItemServiice(int id) {
		
        int count = 0 ;
		
		List<Item> items = entityUtil.manager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("VEG")) 
				count++ ;
		}
		
		return count;
	}


	
	public int getVeganItemServiice(int id) {
		
        int count = 0 ;
		
		List<Item> items = entityUtil.manager.find(FoodOder.class, id).getListItems() ;
		
		for (Item item : items) {
			
			if (item.getType().equals("VEGAN")) 
				count++ ;
		}
		
		return count;
	}


	public List<FoodOder> getAllFoodOrderService() {
		
		Query query = entityUtil.manager.createQuery("from FoodOder");
		return query.getResultList() ;
		 
	}


}
