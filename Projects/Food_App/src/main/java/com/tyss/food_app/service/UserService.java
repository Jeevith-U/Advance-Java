package com.tyss.food_app.service;

import com.tyss.food_app.entity.Users;

public interface UserService {
	
	public Users loginService (String name, String password) ;
	public Users saveUserService (Users users) ;
	public Users getUserbyIdService (int id) ;
	public Users getUserbyUserNamedService (String name,String password) ;
	public Users getUserbyEmailService (String email,String password) ;
	public Users updateUserService (Users users) ;
	public Users getUserByBranchId(int id) ;
	public Users getUserByMenuId(int id) ;
	public Users getUserByFoodOrderId(int id) ;
	public boolean deleteUSerService (int id) ;
}
