package com.tyss.food_app.testservice;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.serviceimplementation.UserServiceImplementation;
import com.tyss.food_app.util.Role;

public class UserServiceTest {
	
	public static void main(String[] args) {
		
		UserServiceImplementation service = new UserServiceImplementation() ;
		
		Users user  = new Users() ;
		
		user.setName("ussop");
		user.setEmail("ussop@gmail.com");
		user.setPassword("ussop@22$$");
		user.setRole(Role.CUSTOMER);
		
		service.saveUserService(user) ;
		
		user = service.getUserbyEmailService("ussop@gmail.com", "ussop@22$$") ;
	}
}
