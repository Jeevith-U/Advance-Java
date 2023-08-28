package com.tyss.food_app.serviceimplementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.service.Food_ProductService;
import com.tyss.food_app.userDaoImplementation.Food_ProductDaoImplementation;
import com.tyss.food_app.util.EntityUtil;

public class Food_ProductServiceImplementation implements Food_ProductService {
	
	EntityUtil entityUtil = new EntityUtil() ;
	
	Food_ProductDaoImplementation dao = new Food_ProductDaoImplementation() ;

	public Food_Product saveFood_Productervice(Food_Product product) {
		
		return dao.saveFoodProduct(product);
	}

	
	public Food_Product updateFood_Productervice(Food_Product product) {
		
		return dao.updateFoodProduct(product);
	}

	
	public boolean deleteFood_Productervice(int id) {
		
		return dao.deleteFoodProduct(id);
	}

	
	public Food_Product getFood_ProductbyIdService(int id) {
		
		return dao.findFoodProduct(id);
	}

	
	public Food_Product getFood_ProductbyNameService(String name) {
		
		Query query = entityUtil.manager.createQuery("select f from Food_Product p where p.name = ?1") ;
		return (Food_Product)query.setParameter(1, name).getSingleResult() ;
	}

	
	public List<Food_Product> getFood_ProductbyMenuIdService(int id) {
		
		Menu menu = entityUtil.manager.find(Menu.class, id) ;
		
		return menu.getProductList() ;
		
	}

	
	public List<Food_Product> getFood_ProductUserIdService(int id) {
		
		return entityUtil.manager.find(Users.class, id).getMenu().getProductList() ;
		
		 
	}


	public List<Food_Product> getAllFood_ProductService() {
		
		Query query = entityUtil.manager.createQuery("from Food_Product") ;
		return query.getResultList() ;
		 
	}

}
