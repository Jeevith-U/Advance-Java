package com.tyss.food_app.UserDaoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.userDaoImplementation.UserDaoImplementation;

public class UserDaoTest {
	
	UserDaoImplementation dao = new UserDaoImplementation();
	
	@Test
	void test() {
		Users user = new Users() ;
		user.setName("Jeevith");
		user.setPassword("Jeevith22$");
		
		Users daoUser = dao.saveUser(user) ;
		
		Assertions.assertEquals(daoUser.getPassword(), user.getPassword());
	}
	
	@Test
	void findUserById() {
		
		int actual_id = 2 ;
		
		Users user = dao.findUser(2);
		
		assertEquals(actual_id, user.getId());
		
	}
	
}
