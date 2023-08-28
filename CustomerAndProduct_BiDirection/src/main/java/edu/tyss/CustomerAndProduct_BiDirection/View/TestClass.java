package edu.tyss.CustomerAndProduct_BiDirection.View;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.CustomerAndProduct_BiDirection.Model.Customer;
import edu.tyss.CustomerAndProduct_BiDirection.Model.Product;

public class TestClass {
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
	public static EntityManager entityManager = entityManagerFactory.createEntityManager();
	public static EntityTransaction entityTransaction = entityManager.getTransaction();

	public static void main(String[] args) {

		Customer c1 = new Customer();
		c1.setId(1);
		c1.setName("SANDEEP");
		c1.setPhno(8324023);

		Product p1 = new Product();
		p1.setId(101);
		p1.setName("tv");
		p1.setPrice(142300);
		p1.setCustomer(c1);

		Product p2 = new Product();
		p2.setId(102);
		p2.setName("mobile");
		p2.setPrice(142300);
		p2.setCustomer(c1);

		Product p3 = new Product();
		p3.setId(1002);
		p3.setName("ac");
		p3.setPrice(142300);
//		
		Customer c2 =new Customer();
		c2.setId(2);
		c2.setName("jeevith");
		c2.setPhno(26378);
		c2.setProducts(Arrays.asList(p1,p3));
//		
		p3.setCustomer(c2);
//		p2.setCustomer(c2);
//		c1.setProducts(Arrays.asList(p2,p1));
		entityTransaction.begin();
		entityManager.persist(p3);
		entityManager.persist(c2);
//		entityManager.persist(c1);
//		entityManager.persist(p1);
		
	
		entityTransaction.commit();
//		
//	Customer p=entityManager.find(Customer.class, 2);
//		System.out.println(p.getId());
//	System.out.println(p.getName());
//	List<Product>products=p.getProducts();
//	for(Product product:products)
//	{
//		System.out.println(product.getName());
//	}
//
//		
	}

}
