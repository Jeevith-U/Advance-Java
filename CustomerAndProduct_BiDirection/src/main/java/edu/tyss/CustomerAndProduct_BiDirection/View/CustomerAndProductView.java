package edu.tyss.CustomerAndProduct_BiDirection.View;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import edu.tyss.CustomerAndProduct_BiDirection.Controller.Controller;
import edu.tyss.CustomerAndProduct_BiDirection.Model.Customer;
import edu.tyss.CustomerAndProduct_BiDirection.Model.Product;

public class CustomerAndProductView {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		CustomerAndProductView view = new CustomerAndProductView() ;
		
		view.create(controller) ;
		
//		view.findCustomerUsingProduct(controller) ;
		
//		view.findProductUsingCustomerID(controller) ;
		
//		view.updateCustomerDetailsUsingProduct(controller) ;
		
//		view.updateProductUsingCustomerId(controller) ;
		
//		view.deleteProductUsingCustomerId(controller) ;
	}

	public void deleteProductUsingCustomerId(Controller controller) {
	
		controller.deleteProductUsingCustomerId(2022, 2012022);
		System.out.println("Deleted..");
		
	}

	private void updateProductUsingCustomerId(Controller controller) {
		
		controller.updateProductUsingCustomerId(2022, 2012022, 399);
		
		System.out.println("Updated...!");
	}

	public void updateCustomerDetailsUsingProduct(Controller controller) {
		
		controller.updateCustomerDetailsUsingProduct(1012022, 9902486);
		System.out.println("Updated...!");
		
	}

	public  void findProductUsingCustomerID(Controller controller) {
		
		 List<Product> products = controller.findProductUsingCustomerID(2022) ;
		 for (Product product : products) {
				
			    System.out.println("Product Id : "+product.getId());
				System.out.println("Product Name : "+product.getName());
				System.out.println("Product Id : "+product.getPrice());
			}
	}

	public void findCustomerUsingProduct(Controller controller) {
		
		Customer customer = controller.findCustomerUsingProduct(2012022) ;
		
		System.out.println("customer Id :"+customer.getId());
		System.out.println("customer Name :"+customer.getName());
		System.out.println("customer phone number :"+customer.getPhno());
		
		
	}

	public void create(Controller controller) {
	
	/*	Customer customer = new Customer() ;
		
		customer.setId(2022);;
		customer.setName("Jeevith U");
		customer.setPhno(96543543);
		
		Product product = new Product() ;
		
		product.setId(1012022);
		product.setName("Head Phones");
		product.setPrice(1599);
		product.setCustomer(customer);
		
		Product product2 = new Product() ;
		
		product2.setId(2012022);
		product2.setName("Dry Fruits");
		product2.setPrice(499);
		product2.setCustomer(customer);
		
		
		List<Product> list = Arrays.asList(product, product2 ) ;
		
		customer.setProducts(list);*/
		
		Customer customer2 = new Customer() ;
		
		customer2.setId(3033);
		customer2.setName("Noor");
		customer2.setPhno(36592638);
		
		Product product3 = Controller.entityManager.find(Product.class, 2012022) ;
				 
		product3.setCustomer(customer2);
		
		Product product4 = new Product() ;
		
		product4.setId(303338);
		product4.setName("Phone");
		product4.setPrice(64999);
		product4.setCustomer(customer2);
		
		List<Product> list = Arrays.asList(product4) ;
		
		customer2.setProducts(list);
		
		controller.save(customer2);
		System.out.println("Added..") ;
		
		
	}
}
