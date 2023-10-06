package com.tyss.spring_foodapp.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dto.FoodOder;
import com.tyss.spring_foodapp.dto.Item;

@Component
@Scope(value = "prototype")
public class FoodOrderDao  {

	@Autowired
	private EntityManager entityManager ;
	
	public FoodOder saveFoodOrder(FoodOder oder) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		entityTransaction.begin();
		entityManager.persist(oder);
		entityTransaction.commit();

		return oder;
	}

	public FoodOder findFoodOrder(int id) {

		FoodOder foodOrder = entityManager.find(FoodOder.class, id);

		if (foodOrder != null)
			return foodOrder;

		return null;
	}

	public FoodOder upadateFoodOrder(FoodOder oder) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		FoodOder updateOrder = findFoodOrder(oder.getId());

		if (updateOrder != null) {
			
			
			oder.setStatus(updateOrder.getStatus());
			oder.setStatus(updateOrder.getStatus());
			oder.setCustomerName(updateOrder.getCustomerName());
			entityManager.merge(updateOrder);
			entityTransaction.commit();
			return updateOrder;
		}

		return null;
	}

	public boolean deleteFoodOrder(int id) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		FoodOder delOrder = findFoodOrder(id);

		if (delOrder != null) {
			entityManager.remove(delOrder);
			entityTransaction.commit();
			return true;
		}

		return false;
	}


	public FoodOder addItemToPresentOrder(int id, Item item) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		FoodOder addOrder = findFoodOrder(id);

		if (addOrder != null) {
			addOrder.getListItems().add(item);
			entityManager.merge(addOrder);
			entityTransaction.commit();
			return addOrder;
		}

		return null;
	}

}
