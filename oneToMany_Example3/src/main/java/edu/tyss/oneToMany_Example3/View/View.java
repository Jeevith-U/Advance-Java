package edu.tyss.oneToMany_Example3.View;

import java.util.Arrays;
import java.util.List;

import edu.tyss.oneToMany_Example3.Controller.Controller;
import edu.tyss.oneToMany_Example3.model.Customer;
import edu.tyss.oneToMany_Example3.model.Mall;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createMall(controller) ;
		
//		controller.findAllCustomer(2435);
		
//		controller.updateCustomerDetail(2435, 212, "Jee");
		
		controller.deleteCustomer(2435, 212);
	}

	public void createMall(Controller controller) {
		
		Mall mall = new Mall() ;
		
		mall.setId(2435);
		mall.setName("phinox");
		
		Customer customer = new Customer() ;
		
		customer.setId(212);
		customer.setName("Jeevith");
		customer.setPhno(765276);
		
		Customer customer2 = new Customer() ;
		
		customer2.setId(7836);
		customer2.setName("meerai");
		customer2.setPhno(325632);
		
		List<Customer> customers = Arrays.asList(customer, customer2) ;
		
		mall.setCustomers(customers);
		controller.save(mall);
		System.out.println("saved");
	}
}
