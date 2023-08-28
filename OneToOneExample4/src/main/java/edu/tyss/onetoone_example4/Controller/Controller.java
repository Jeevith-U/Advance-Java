package edu.tyss.onetoone_example4.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.onetoone_example4.model.Car;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void saveCarDetails(Car car) {
		
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(car.getDetails());
		entityTransaction.commit();
	}
	
	public void findCarDetails(String num) {
		
		Car car = entityManager.find(Car.class, num) ;
		System.out.println("Car Id : "+car.getCarNumber());
		System.out.println("Car Id : "+car.getColor());
		System.out.println("Car Id : "+car.getPrice());
		
		System.out.println();
		System.out.println("Car Details :-");
		System.out.println(car.getDetails().getId());
		System.out.println(car.getDetails().getName());
		System.out.println(car.getDetails().getOwnerShip());
		
	}
	
	public void updateCarDetails(String Num, String ownsership) {
		
		Car car = entityManager.find(Car.class, Num) ;
		
		entityTransaction.begin();
		car.getDetails().setOwnerShip(ownsership);
		entityManager.merge(car);
		entityTransaction.commit();
	}
	
	public void deleteCar(String num) {
		
		Car car = entityManager.find(Car.class, num) ;
		
		entityTransaction.begin();
		entityManager.remove(car);
		entityTransaction.commit();
	}
}
