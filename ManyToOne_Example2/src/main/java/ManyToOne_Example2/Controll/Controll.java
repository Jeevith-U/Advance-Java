package ManyToOne_Example2.Controll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ManyToOne_Example2.Model.ElectronicDevice;

public class Controll {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void save(ElectronicDevice device) {
		
		entityTransaction.begin();
		entityManager.persist(device);
	    entityManager.persist(device.getPerson());
		entityTransaction.commit(); 
	}
	
	public void findPerson(int id) {
		
		ElectronicDevice device = entityManager.find(ElectronicDevice.class, id) ;
		
		System.out.println("Device Id : "+device.getId());
		System.out.println("Device Name : "+device.getName());
		System.out.println("Device Price : "+device.getPrice());
		
		System.out.println();System.out.println("Person Details ");
		System.out.println("Person Id : "+device.getPerson().getId());
		System.out.println("Person Name : "+device.getPerson().getName());
	}
	
	public void updateName(int id, double price) {
		
		entityTransaction.begin();
		ElectronicDevice device = entityManager.find(ElectronicDevice.class, id) ;
		device.setPrice(price);
		entityManager.merge(device);
		entityTransaction.commit();
	}
	
	public void deleteDevice(int id) {
		
		ElectronicDevice device = entityManager.find(ElectronicDevice.class, id) ;
		
		entityTransaction.begin();
		entityManager.remove(device);
		entityTransaction.commit();
	}
}
