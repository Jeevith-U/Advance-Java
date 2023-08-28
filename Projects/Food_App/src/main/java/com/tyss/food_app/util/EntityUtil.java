package com.tyss.food_app.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityUtil {
	
	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jeevith") ;
	public static EntityManager manager = factory.createEntityManager() ;
	public static EntityTransaction transaction = manager.getTransaction() ;
}
