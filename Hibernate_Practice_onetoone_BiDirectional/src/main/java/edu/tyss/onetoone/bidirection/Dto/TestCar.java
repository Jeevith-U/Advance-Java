package edu.tyss.onetoone.bidirection.Dto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.onetoone.bidirection.model.Car;
import edu.tyss.onetoone.bidirection.model.Engine;

public class TestCar {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	
	public static void main(String[] args) {
		
		
		TestCar testCar = new TestCar() ;
		
//		testCar.createNewCarAndEngine() ;
		
//		testCar.findDetails() ;
		
		testCar.findDetailsUsingEngine() ;
	}


	public void findDetailsUsingEngine() {
		
		Engine engine = entityManager.find(Engine.class, 32035) ;
		System.out.println("Engine Id : "+engine.getId());
		System.out.println("Engine Name : "+engine.getName());
		System.out.println("Engine CC : "+engine.getCc());
		System.out.println();
		
		System.out.println("Car Details ");
		
		System.out.println("Car ID : "+engine.getCar().getId());
		System.out.println("Car Name : "+engine.getCar().getName());
		System.out.println("Car price : "+engine.getCar().getPrice());
		
		
	}


	public void findDetails() {
		
		Car car = entityManager.find(Car.class, 456) ;
		
		System.out.println("Car ID : "+car.getId());
		System.out.println("Car Name : "+car.getName());
		System.out.println("Car price : "+car.getPrice());
		System.out.println();
		System.out.println("Engine Details ");
		System.out.println("Engine ID : "+car.getEngine().getId());
		System.out.println("Engine ID : "+car.getEngine().getName());
		System.out.println("Engine ID : "+car.getEngine().getCc());
		
	}


	public void createNewCarAndEngine() {
		
		Car car = new Car() ;
		car.setId(456);
		car.setName("BMW");
		car.setPrice(42700000);
		
		Engine engine = new Engine() ;
		engine.setId(6332);
		engine.setName("ME3");
		engine.setCc(4000);
		
		car.setEngine(engine);
		engine.setCar(car); 
		
		entityTransaction.begin();
		entityManager.persist(car);
		entityManager.persist(engine);
		entityTransaction.commit();
		System.out.println("Car and Engine Details Are created...!");
		
	}
}
