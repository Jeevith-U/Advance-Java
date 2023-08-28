package edu.tyss.OneToOneExample3.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.OneToOneExample3.model.Telivision;

public class Controller {
	
	    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		static EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		public void saveTelivision(Telivision telivision) {
			
			entityTransaction.begin();
			entityManager.persist(telivision);
			entityManager.persist(telivision.getRemote());
			entityTransaction.commit();
		}
		
		public void findDetails(int tvId) {
			
			Telivision tv = entityManager.find(Telivision.class, tvId) ;
			
			System.out.println("Telivision Id : "+tv.getId());
			System.out.println("Telivision Name : "+tv.getBrandName());
			System.out.println("Telivision Price : "+tv.getPrice());
			System.out.println();
			System.out.println("Remote Details -");
			System.out.println("Remote Id :"+tv.getRemote().getId());
			System.out.println("Remote Name :"+tv.getRemote().getBrand());
			System.out.println("Remote Price :"+tv.getRemote().getPrice());
		}
		
		public void updateRemoteDetails(int id, String name) {
			
			Telivision tv = entityManager.find(Telivision.class, id) ;
			entityTransaction.begin();
			tv.getRemote().setBrand(name);
			entityManager.merge(tv) ;
			entityTransaction.commit();
		}
		
		public void deleteTelivision(int id) {
			
			Telivision tv = entityManager.find(Telivision.class, id) ;
			
			entityTransaction.begin();
			entityManager.remove(tv);
			entityTransaction.commit();
		}
}
