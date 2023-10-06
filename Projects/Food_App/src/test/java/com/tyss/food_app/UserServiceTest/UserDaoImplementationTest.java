package com.tyss.food_app.UserServiceTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.serviceimplementation.UserServiceImplementation;
import com.tyss.food_app.userDaoImplementation.UserDaoImplementation;
import com.tyss.food_app.util.Role;

public class UserDaoImplementationTest {
	
	private static UserDaoImplementation dao ;
	private static UserServiceImplementation service ;
	private static EntityManagerFactory entityManagerFactory ;
	private static EntityManager entityManager ;
	
	@Before
	public static void BeforeAllMethod() {
		
		dao = new UserDaoImplementation() ;
		
		entityManagerFactory =  dao.entityManagerFactory ;
	}
	
	@BeforeEach
	void setup() throws Exception{
		entityManager = dao.entityManager ;
	}
	
	@Test
	public void testSaveUserService(Users users) {
		
		Users expectedUser = new Users() ;
		expectedUser.setEmail("jeevith@gmail.com");
		expectedUser.setName("Jeevith");
		expectedUser.setRole(Role.BRANCHMANAGER);
		expectedUser.setPassword("Jeevi@@$$");
		dao.saveUser(expectedUser) ;
	}
}
