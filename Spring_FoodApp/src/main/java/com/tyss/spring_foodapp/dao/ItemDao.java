package com.tyss.spring_foodapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dto.Item;

@Component
@Scope(value = "prototype")
public class ItemDao {

	@Autowired
	private EntityManager entityManager;

	public Item saveItem(Item item) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

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
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		Item updateItem = findItem(item.getId());

		if (updateItem != null) {

			item.setName(updateItem.getName());
			item.setQuantity(updateItem.getQuantity());
			entityManager.merge(updateItem);
			entityTransaction.commit();
			return updateItem;
		}

		return null;
	}

	public boolean deleteItem(int id) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
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
