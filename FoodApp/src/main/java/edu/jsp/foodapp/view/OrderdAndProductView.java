package edu.jsp.foodapp.view;

import java.util.Scanner;

import edu.jsp.foodapp.bean.Order;
import edu.jsp.foodapp.bean.Product;
import edu.jsp.foodapp.controller.OrderController;
import edu.jsp.foodapp.controller.ProductController;

public class OrderdAndProductView {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in) ;
		ProductController productController = new ProductController() ;
		OrderController orderController = new OrderController() ;
		
		boolean flag0 = true ;
		while (flag0) {
			
			System.out.println("Select on what you want perform Operation \n1. Order \n2. Product \n0. Exit");
			int choice = scan.nextInt() ;
			
			if (choice == 0) {
				flag0 = false ;
			}
			
			if (choice == 1) {
				
				boolean falg1 = true ;
				while (falg1) {
					System.out.println("Select the operation that you want to perform \n1. Order \n2. Find Order By Id \n3. Update Order By ID \n4. Delete Order by ID \n0. Exit");
					int choice1 = scan.nextInt() ;
					
					switch (choice1) {
					case 1:
						saveOrder(scan, orderController) ;
						break;
					case 2:
						findOrderByName(scan,orderController) ;
						break;
					case 3:
						updateOrder(scan, orderController) ;
						break;
					case 4:
						
						break;
					case 0:
						falg1 = false ;
						break;

					default:
						break;
					}
				}
				
			}else if (choice == 2) {
				
				boolean flag2 = true ;
				while (flag2) {
					System.out.println("Select the operation that you want to perform \n1. Add product \n2. Find Product By Order Id \n3. Update Product By ID \n4. Delete Product by ID \n0. Exit");
					int choice2 = scan.nextInt() ;
					
					switch (choice2) {
					case 1:
						Product product = addProduct(scan) ;
						productController.saveProduct(product);
						break;
					case 2:
						int id = findproductByID(scan) ;
						Product returenedProduct = productController.fetchProductById(id) ;
						printProduct(returenedProduct) ;
						break;
					case 3:
						updateProduct(scan, productController) ;
						break;
					case 4:
						deleteProductById(scan, productController) ;
						break;
					case 0:
						flag2 = false ;
						break;

					default:
						break;
					}
				}
			}
		}
	}

	private static void updateOrder(Scanner scan, OrderController orderController) {
		
		System.out.println("Enter the Old Order Name ");
		String oldName = scan.next() ;
		System.out.println("Enter the new Order Name ");
		String newname = scan.next() ;
		
		orderController.updateOrderName(newname, oldName) ;
	}

	private static void findOrderByName(Scanner scan, OrderController orderController) {
		
		System.out.println("Enter the Order Name ");
		String name = scan.next() ;
		Order order = orderController.findOrderByOrderName(name) ;
		System.out.println("Oder Id :"+order.getOrderId());
		System.out.println("Order Name :"+order.getOrderName());
		
	}

	private static void saveOrder(Scanner scan, OrderController orderController) {
		
		Order order = new Order() ;
		System.out.println("Enter the order Id");
		int id = scan.nextInt() ;
		System.out.println("Enter the OrderName ");
		String name = scan.next() ;
		
		order.setOrderId(id);
		order.setOrderName(name);
		
		orderController.saveOrder(order);
	}

	private static void deleteProductById(Scanner scan, ProductController productController) {
		
		System.out.println("Enter the ID you Want to Delete");
		int id = scan.nextInt() ;
		System.out.println(productController.deleteProductById(id));
	}

	private static void updateProduct(Scanner scan, ProductController controller) {
		System.out.println("Enter the product ID that you want to update ");
		int id = scan.nextInt() ;
		System.out.println("Enter the Product Price ");
		double price = scan.nextDouble() ;
		
		System.out.println(controller.updateProductById(id, price));
	}

	private static void printProduct(Product product) {
		
		System.out.println("Product ID:"+product.getOrderId());
		System.out.println("Product name :"+product.getProductName());
		System.out.println("Product Discription :"+product.getDiscription());
		System.out.println("Product Price :"+product.getPrice());
		System.out.println("Product OrderId :"+product.getOrderId());
		
	}

	private static int findproductByID(Scanner scan) {
		
		System.out.println("Enter the Product Id that You want to find");
		int find = scan.nextInt() ;
		return find;
		
	}

	private static Product addProduct(Scanner scan) {
		
		Product product = new Product() ;
		
		System.out.println("Enter the Product ID");
		int pId = scan.nextInt() ;
		System.out.println("Enter the Product Name");
		scan.nextLine() ;
		String name = scan.nextLine() ;
		System.out.println("Enter the Product Discription ");
		String discription = scan.nextLine() ;
		System.out.println("Enter the Product Price");
		double price = scan.nextDouble() ;
		System.out.println("Enter the OrderID");
		int oId = scan.nextInt() ;
		
		product.setProductId(pId);
		product.setProductName(name);
		product.setDiscription(discription);
		product.setPrice(price);
		product.setOrderId(oId);
		
		return product ;
	}
}
