package com.tyss.food_app.userDaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.entity.Item;
import com.tyss.food_app.userDao.FoodOrder;

public class FoodOrderImplementation implements FoodOrder {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOder saveFoodOrder(FoodOder oder) {

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

		entityTransaction.begin();

		FoodOder delOrder = findFoodOrder(id);

		if (delOrder != null) {
			entityManager.remove(delOrder);
			entityTransaction.commit();
			return true;
		}

		return false;
	}

	public FoodOder trackFoodOrder(FoodOder foodOder) {

		return null;
	}

	public FoodOder addItemToPresentOrder(int id, Item item) {

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
