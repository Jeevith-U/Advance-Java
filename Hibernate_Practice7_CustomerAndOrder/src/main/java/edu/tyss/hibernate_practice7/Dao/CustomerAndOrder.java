package edu.tyss.hibernate_practice7.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.criterion.Order;

import edu.tyss.hibernate_practice7.model.Cart;
import edu.tyss.hibernate_practice7.model.Customer;

public class CustomerAndOrder {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	static Scanner scanner = new Scanner(System.in) ;
	
	public static void main(String[] args) {
		
		CustomerAndOrder customerAndOrder = new CustomerAndOrder() ;
		
		customerAndOrder.saveCustomerAndOrder() ;
		
//		customerAndOrder.findProductById(9876543, 8234567);
		
//		customerAndOrder.updateOrder(9876543, 8234567, 8);
		
//		customerAndOrder.delOrderFromCart(9876543, 8234567);
		
		
	}

	public void saveCustomerAndOrder() {
		
		Customer customer11 = new Customer() ;
		customer11.setId(54536);
		customer11.setName("kiran");
		customer11.setPhno("98765432");
		customer11.setEmail("kiran@gmail.com");
		
		List<Cart> orders = new ArrayList<Cart>() ;
		
		Cart cart23 = new Cart() ;
		cart23.setId(43545);
		cart23.setOrderNumber("kiranhg987654");
		cart23.setTotalPrice(6587650);
		cart23.setNumberOfItems(2);
		
		Cart cart26 = new Cart() ;
		
		cart26.setId(5435362);
		cart26.setOrderNumber("kiran76543");
		cart26.setTotalPrice(999);
		cart26.setNumberOfItems(1);
		
		orders.add(cart23) ;
		orders.add(cart26) ;
		
		customer11.setOrders(orders);
		
		entityTransaction.begin(); 
		
		entityManager.persist(customer11);
		entityManager.persist(cart23);
		entityManager.persist(cart26);
		
		entityTransaction.commit();
		
		System.out.println("Ordered Successfully...!");
		
	}
	
	public void findProductById(long cid, long oid) {
		
		Customer custmor = entityManager.find(Customer.class, cid) ;
		
		List<Cart> orders = custmor.getOrders() ;
		
		for (Cart order : orders) {
			
			if (order.getId() == oid) {
				
				System.out.println("Oder Id : "+order.getId());
				System.out.println("Oder Id : "+order.getOrderNumber());
				System.out.println("Oder Id : "+order.getTotalPrice());
				System.out.println("Oder Id : "+order.getTotalPrice());
				System.out.println("Oder Id : "+order.getNumberOfItems());
			}
		}
	}
	
	public void updateOrder(long cid, long oid ,int numofItem) {
		
		entityTransaction.begin(); 
        Customer custmor = entityManager.find(Customer.class, cid) ;
		
		List<Cart> orders = custmor.getOrders() ;
		
		for (Cart order : orders) {
			
			if (order.getId() == oid) {
				
				order.setNumberOfItems(numofItem);
				entityManager.merge(order) ;
			} 
			
		}
		
		entityTransaction.commit();
		System.out.println("Order Updated Sucessfully");
	}
	
	public void delOrderFromCart(long cid, long oid) {
		
		entityTransaction.begin(); 
        Customer custmor = entityManager.find(Customer.class, cid) ;
        List<Cart> cart = custmor.getOrders() ;
        
        Cart delCart = null ;
        for (Cart cart2 : cart) {
			
        	if (cart2.getId() == oid) {
				
        		delCart = cart2 ;
        		
			}
		}
        cart.remove(delCart) ;
        entityManager.remove(delCart);
        custmor.setOrders(cart);
        entityManager.merge(custmor) ;
//        entityManager.merge(cart) ;
        entityTransaction.commit(); 
        System.out.println("Order Deleted..");
	}
}
