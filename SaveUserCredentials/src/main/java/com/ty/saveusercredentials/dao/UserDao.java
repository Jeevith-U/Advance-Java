package com.ty.saveusercredentials.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.saveusercredentials.dto.UserEmailAndPassword;

public class UserDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public boolean saveUserCredentials(UserEmailAndPassword user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return false;
		
	}
}
