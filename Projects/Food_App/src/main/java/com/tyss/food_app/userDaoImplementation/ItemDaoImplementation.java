package com.tyss.food_app.userDaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Item;
import com.tyss.food_app.userDao.ItemDao;

public class ItemDaoImplementation implements ItemDao {
	

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	public Item saveItem(Item item) {
		
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();

		return item;
	}
	
	public Item findItem(int id) {
		
		 Item item = entityManager.find(Item.class, id);

		if (item != null)
			return item;

		return null;
	}
	
	public Item updateItem(Item item) {
		
		entityTransaction.begin();

		 Item updateItem = findItem(item.getId());

		if (updateItem != null) {

			item.setName(updateItem.getName());
			item.setQuantity(updateItem.getQuantity()) ;
			entityManager.merge(updateItem);
			entityTransaction.commit();
			return updateItem;
		}

		return null;
	}
	
	public boolean deleteItem(int id) {
		
		entityTransaction.begin();

		 Item deleteItem = findItem(id);

		if (deleteItem != null) {

			entityManager.remove(deleteItem);
			entityTransaction.commit();
			return true;
		}

		return false;
	}
	
	public String itemReview(String review) {
		
		return review;
	}

}
