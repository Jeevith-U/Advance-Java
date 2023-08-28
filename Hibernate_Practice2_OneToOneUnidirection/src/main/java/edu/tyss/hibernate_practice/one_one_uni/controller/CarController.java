package edu.tyss.hibernate_practice.one_one_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.hibernate_practice.one_one_uni.model.Car;
import edu.tyss.hibernate_practice.one_one_uni.model.Engine;

public class CarController {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		
	static EntityManager entityManager =entityManagerFactory.createEntityManager() ;
	
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		Engine engine = new Engine() ;
		
		engine.setEid(1100);
		engine.setType("F1");
		engine.setCc(1800);
		
		Car car = new Car() ;
		
		car.setId(2202);
		car.setName("Audi");
		car.setPrice(502200);
		car.setEngine(engine);
		
		entityTransaction.begin();
		
		entityManager.persist(car) ;
		entityManager.persist(engine) ;
		
		entityTransaction.commit(); 
	}
}
