package com.tyss.food_app.userDaoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.userDao.Food_ProductDao;

public class Food_ProductDaoImplementation implements Food_ProductDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Food_Product saveFoodProduct(Food_Product Product) {

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

		entityTransaction.begin();

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

		entityTransaction.begin();

		Food_Product deleteProduct = findFoodProduct(id);

		if (deleteProduct != null) {
			entityManager.remove(deleteProduct);
			entityTransaction.commit();
			return true;
		}

		return false;
	}

}
