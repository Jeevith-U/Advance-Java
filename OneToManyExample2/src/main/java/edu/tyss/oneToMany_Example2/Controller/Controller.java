package edu.tyss.oneToMany_Example2.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.oneToMany_Example2.model.Driver;
import edu.tyss.oneToMany_Example2.model.Uber;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void bookUber(Uber uber) {
		
		entityTransaction.begin();
		entityManager.persist(uber);
		for(Driver driver : uber.getDrivers()) {
			entityManager.persist(driver);
		}
		entityTransaction.commit();
	}
	
	public void FindAllUberDriver(int id) {
		
		Uber uber = entityManager.find(Uber.class, id) ;
		
		for(Driver driver : uber.getDrivers()) {
			
			System.out.println("Driver Id : "+driver.getId());
			System.out.println("Driver Name : "+driver.getName());
			System.out.println("Driver Distance : "+driver.getDistance());
			System.out.println("Driver charge : "+driver.getPrice());
			System.out.println();
		}
	}
	
	public void updateDriverName(int id, int did, String newName) {
		
        Uber uber = entityManager.find(Uber.class, id) ;
		entityTransaction.begin();
		for(Driver driver : uber.getDrivers()) {
			if (driver.getId() == did) {
				driver.setName(newName);
				entityManager.persist(driver);
				entityManager.persist(uber);
			}
		}
		entityTransaction.commit();
	}
	
	public void deleteDriver(int id, int did) {
		
		Uber uber = entityManager.find(Uber.class, id) ;
		
		List<Driver> list = uber.getDrivers() ;
		
		Driver deldriver = null ;
		
		for(Driver driver : list ) {
			if (driver.getId() == did) {
				deldriver = driver ;
			}
		}
		entityTransaction.begin();
		list.remove(deldriver) ;
		entityManager.remove(deldriver);
		entityManager.merge(uber) ;
		entityTransaction.commit();
		
	}
}
