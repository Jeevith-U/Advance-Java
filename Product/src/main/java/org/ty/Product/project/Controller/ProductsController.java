package org.ty.Product.project.Controller;

import java.util.Scanner;

import org.ty.Product.Products.Products;
import org.ty.Product.project.Dao.ProductDao;

public class ProductsController {

	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao() ;
		
	/*	dao.removeProductById(13); 
		
		pro.getId() ;
		pro.setPrice(22220); 
		
		dao.updateProductById(pro) ;
		
		dao.findByProductId(42) ;*/
		
		Scanner sc =  new Scanner(System.in) ;
		
		System.out.println("Enter the operation you wanna perform\n1. saveProduct \n2. findByProductId\n3. updateProductById\n4. removeProductById");
		
		int operation = sc.nextInt() ;
		
		switch (operation) {
		case 1:
			Products pro = new Products() ;
			
			pro.setId(88);
			pro.setName("watch");
			pro.setType("Analog");
			pro.setDescription("only for the gaming purpose ");
			pro.setAvailability("yes");
			pro.setPrice(4000);
			
			dao.saveProduct(pro) ;
			break;
			
		case 2:
			System.out.println("Enter the product id that you wanna fetch ");
			int id = sc.nextInt() ;
			Products product = dao.findByProductId(id) ;
			
			System.out.println("Product id :"+product.getId());
			System.out.println("Product name :"+product.getName());
			System.out.println("Product type :"+product.getType() );
			System.out.println("Product availability :"+product.getAvailability());
			System.out.println("Product discription :"+product.getDescription());
			System.out.println("Product price :"+product.getPrice());
			
			break;
			
		case 3:
			Products prod = new Products() ;
			System.out.println("Enter the ID you wanna Update ");
			int did = sc.nextInt() ;
			System.out.println("Enter the Updated price ");
			Double pri = sc.nextDouble() ;
			prod.setId(did);
			prod.setPrice(pri);
			
		    Products up=dao.updateProductById(prod) ;
		    
		    
		    System.out.println("Product id :"+up.getId());
			System.out.println("Product name :"+up.getName());
			System.out.println("Product type :"+up.getType() );
			System.out.println("Product availability :"+up.getAvailability());
			System.out.println("Product discription :"+up.getDescription());
			System.out.println("Product price :"+up.getPrice());
			break ;
			
			
		default:
			break;
		}
	}

}
