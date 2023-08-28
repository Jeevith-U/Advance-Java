package edu.tyss.ManyToOne_Example3.Controll;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.ManyToOne_Example3.model.Address;

public class Controll {
	
	    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		static EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		public void save(Address address) {
			
			entityTransaction.begin();
			entityManager.persist(address);
		    entityManager.persist(address.getPerson());
			entityTransaction.commit(); 
		}
		
		public void findVehi(int id) {
			
			Address add = entityManager.find(Address.class, id);
			
			System.out.println("Address Pincode : "+add.getPincode());
			System.out.println("Address name : "+add.getName());
			
			System.out.println();
			System.out.println("Person Details ");
			System.out.println("Person Id : "+add.getPerson().getId());
			System.out.println("Person Name : "+add.getPerson().getName());
		}
		
		public void updateAddress(int id, String name) {
			entityTransaction.begin();
			Address add = entityManager.find(Address.class, id);
			add.setName(name);
			entityManager.merge(add) ;
			entityTransaction.commit();
		}
		
		public void deleteAddress(int id) {
			
			Address add = entityManager.find(Address.class, id);
			
			entityTransaction.begin();
			entityManager.remove(add);
			entityTransaction.commit();
		}
		
		
}
