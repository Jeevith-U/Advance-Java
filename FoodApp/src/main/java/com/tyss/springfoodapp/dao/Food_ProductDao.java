package com.tyss.springfoodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.springfoodapp.dto.Food_Product;

@Component
@Scope(value = "prototype")
public class Food_ProductDao  {

	@Autowired
	private EntityManager entityManager ;
	
	
	public Food_Product saveFoodProduct(Food_Product Product) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		entityTransaction.begin();
		entityManager.persist(Product);
		entityTransaction.commit();

		return Product;
	}

	public Food_Product findFoodProduct(int id) {

		Food_Product foodproduct = entityManager.find(Food_Product.class, id);

		if (foodproduct != null)
			return foodproduct;

		return null;
	}

	public Food_Product updateFoodProduct(Food_Product Product) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

//		entityTransaction.begin();

		Food_Product updateProduct = findFoodProduct(Product.getId());

		if (updateProduct != null) {
			Product.setAvailability(updateProduct.getAvailability());
			Product.setName(updateProduct.getName());
			Product.setAbout(updateProduct.getAbout());
			entityManager.merge(updateProduct);
			entityTransaction.commit();
			return updateProduct;
		}

		return null;
	}

	public boolean deleteFoodProduct(int id) {
		
		EntityTransaction entityTransaction = entityManager.getTransaction() ;

		entityTransaction.begin();

		Food_Product deleteProduct = findFoodProduct(id);

		if (deleteProduct != null) {
			entityManager.remove(deleteProduct);
			entityTransaction.commit();
			return true;
		}

		return false;
	}
	
	public List<Food_Product> findAllFoodProducts(){
		Query query = entityManager.createQuery("from Food_Product") ;
		return query.getResultList() ;
	}

}
