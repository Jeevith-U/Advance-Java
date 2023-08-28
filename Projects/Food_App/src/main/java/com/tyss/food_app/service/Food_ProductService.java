package com.tyss.food_app.service;

import java.util.List;

import com.tyss.food_app.entity.Food_Product;

public interface Food_ProductService {
	
	public Food_Product saveFood_Productervice (Food_Product product) ;
	public Food_Product updateFood_Productervice (Food_Product product) ;
	public boolean deleteFood_Productervice (int id) ;
	public Food_Product getFood_ProductbyIdService (int id) ;
	public Food_Product getFood_ProductbyNameService (String name) ;
	public List<Food_Product> getFood_ProductbyMenuIdService (int id) ;
	public List<Food_Product> getAllFood_ProductService () ;
	public List<Food_Product> getFood_ProductUserIdService (int id) ;
}
