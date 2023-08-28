package com.tyss.food_app.userDao;

import com.tyss.food_app.entity.Users;

public interface UserDao {
	
	public Users saveUser(Users user) ;
	
	public Users findUser(int id) ;
	
	public Users updateUser(Users user) ;
	
	public boolean deleteUsers(int id) ;
	
	public String writeSuggetions(String suggestion) ;
	
	public boolean loginUser(String name, String password) ;
	
}