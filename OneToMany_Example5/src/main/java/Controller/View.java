package Controller;

import java.util.Arrays;
import java.util.List;

import Model.Company;
import Model.Product;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
		view.create(controller) ;
		
		controller.findAllProduct(101);
		
		controller.updateCompany(101, 203, "Brush");
		
		controller.deleteCustomer(101, 203);
		
		
	}

	public void create(Controller controller) {
		
		Company company = new Company() ;
		
		company.setId(101);
		company.setId("Himalya");
		
		Product product = new Product() ;
		product.setId(202);
		product.setName("Face Wash");
		product.setPrice(240);
		
		Product product1 = new Product() ;
		product1.setId(203);
		product1.setName("Soap");
		product1.setPrice(40);
		
		List<Product> list = Arrays.asList(product, product1) ;
		
		company.setListOfProducts(list);
		
		controller.save(company);
		System.out.println("Added..");
		
	}
}
