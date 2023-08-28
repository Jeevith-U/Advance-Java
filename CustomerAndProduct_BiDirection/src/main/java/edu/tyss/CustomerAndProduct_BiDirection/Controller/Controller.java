package edu.tyss.CustomerAndProduct_BiDirection.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.CustomerAndProduct_BiDirection.Model.Customer;
import edu.tyss.CustomerAndProduct_BiDirection.Model.Product;

public class Controller {
	
	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	public static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	public static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public void save(Customer customer) {
		
		entityTransaction.begin();
		entityManager.persist(customer);
		for( Product product : customer.getProducts()) {
		entityManager.persist(product);
		}
		entityTransaction.commit();
	}
	
	public Customer findCustomerUsingProduct(int pid) {
		
		Product product = entityManager.find(Product.class, pid);
		
		return product.getCustomer() ;
	}
	
	public List<Product> findProductUsingCustomerID(int cid) {
		
	    Customer customer = entityManager.find(Customer.class, cid) ;
	    
	    List<Product> list = customer.getProducts() ;
	    
	    return list ;
	}
	
	public void updateCustomerDetailsUsingProduct(int pid, long phno) {
		
		Product product = entityManager.find(Product.class, pid);
		
		entityTransaction.begin();
		product.getCustomer().setPhno(phno);
		entityManager.merge(product) ;
		entityTransaction.commit();
	}
	
	public void updateProductUsingCustomerId(int cid, int pid, double price) {
		
		 Customer customer = entityManager.find(Customer.class, cid) ;
		    
		    List<Product> list = customer.getProducts() ;
		    entityTransaction.begin();
		    for (Product product : list) {
				
		    	if (product.getId() == pid) {
					
		    		product.setPrice(price);
		    		entityManager.merge(customer) ;
		    		
				}
			}
		    entityTransaction.commit();
	}
	
	public void deleteProductUsingCustomerId(int cid, int pid) {
		
		Customer customer = entityManager.find(Customer.class, cid) ;
	    
	    List<Product> list = customer.getProducts() ;
	    Product delProduct = null ;
	    entityTransaction.begin();
	    for (Product product : list) {
			
	    	if (product.getId() == pid) {
	    		delProduct = product ;
			}
		}
	    list.remove(delProduct) ;
	    entityManager.remove(delProduct);
	    entityManager.merge(customer) ;
	    entityTransaction.commit();
	}
}
