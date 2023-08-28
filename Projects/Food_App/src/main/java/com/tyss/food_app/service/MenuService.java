package com.tyss.food_app.service;

import java.util.List;

import com.tyss.food_app.entity.Menu;

public interface MenuService {
	
	public Menu saveMenuervice (Menu menu) ;
	public Menu getMenubyIdService (int id) ;
	public Menu getMenubyBranchIdService (int id) ;
	public Menu getMenuUserIdService (int id) ;
	public Menu updateMenuervice (Menu menu) ;
	public boolean deleteMenuervice (int id) ;
	public List<Menu> getAllMenuervice () ;
}
