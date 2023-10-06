package com.tyss.spring_foodapp.service;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tyss.spring_foodapp.dao.Food_ProductDao;
import com.tyss.spring_foodapp.dto.Food_Product;
import com.tyss.spring_foodapp.dto.Menu;
import com.tyss.spring_foodapp.dto.Users;

@Component
@Scope(value = "prototype")
public class Food_ProductService {
	
	@Autowired
	private Food_ProductDao dao ;
	
	@Autowired
	private EntityManager entityManager ;
	
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
		
		javax.persistence.Query query = entityManager.createQuery("select f from Food_Product p where p.name = ?1") ;
		return (Food_Product)query.setParameter(1, name).getSingleResult() ;
	}

	
	public List<Food_Product> getFood_ProductbyMenuIdService(int id) {
		
		Menu menu = entityManager.find(Menu.class, id) ;
		
		return menu.getProductList() ;
		
	}

	
	public List<Food_Product> getFood_ProductUserIdService(int id) {
		
		return entityManager.find(Users.class, id).getMenu().getProductList() ;
		
		 
	}


	public List<Food_Product> getAllFood_ProductService() {
		
		javax.persistence.Query query = entityManager.createQuery("from Food_Product") ;
		return query.getResultList() ;
		 
	}

}
