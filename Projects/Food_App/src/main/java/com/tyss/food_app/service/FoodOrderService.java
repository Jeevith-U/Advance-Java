package com.tyss.food_app.service;

import java.util.List;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.FoodOder;

public interface FoodOrderService {
	
	public FoodOder saveFoodOder(FoodOder order) ;
	public FoodOder updateFoodOder(FoodOder order) ;
	public boolean deleteFoodOder(int id) ;
	public FoodOder getFoodOderbyIdService (int id) ;
	public FoodOder getFoodOderbyCustomerNameService (String name) ;
	public double gettotalPriceofFoodOrder(int id) ;
	public int getNonvegItemServiice(int id) ;
	public int getBVegItemServiice(int id) ;
	public int getVeganItemServiice(int id) ;
	public List<FoodOder> getAllFoodOrderService() ;
	public FoodOder getFoodOderbyCustomerPhoneNumberService (long phno) ;
}
