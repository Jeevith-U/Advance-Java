package edu.tyss.manytoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.manytoone.Model.Product;
import edu.tyss.manytoone.Model.Reviews;
import net.bytebuddy.jar.asm.signature.SignatureWriter;

public class TestSave {
	
	public static void main(String[] args) {
		
		
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		 EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		 EntityTransaction entityTransaction = entityManager.getTransaction() ;
		 
		 /* Product product =new Product() ;
		 
		 product.setId(2022);
		 product.setName("iPhone");
		 product.setCost(70000);
		 
		 Reviews reviews = new Reviews() ;
		 
		 reviews.setId(101);
		 reviews.setHeading("Good One");
		 reviews.setMessage("This is Good Product");
		 reviews.setProduct(product);
		 
		 Reviews reviews2 = new Reviews() ;
		 
		 reviews2.setId(102);
		 reviews2.setHeading("Best One");
		 reviews2.setMessage("This is Too pricey but good to use");
		 reviews2.setProduct(product);
		 
		 entityTransaction.begin();
		 entityManager.persist(product);
		 entityManager.persist(reviews);
		 entityManager.persist(reviews2);
		 entityTransaction.commit();
		 
		 System.out.println("Data Enterd...!");*/
		 
		Reviews result = entityManager.find(Reviews.class, 101) ;
		
		System.out.println(result.getId());
		System.out.println(result.getHeading());
		System.out.println(result.getMessage());
		
		Product product = result.getProduct() ;
		
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getCost());
		
	}

}
