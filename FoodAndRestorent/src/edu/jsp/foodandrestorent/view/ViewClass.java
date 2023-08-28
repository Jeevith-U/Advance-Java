package edu.jsp.foodandrestorent.view;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

import edu.jsp.foodandrestorent.Controller.Controller;
import edu.jsp.foodandrestorent.model.Customer;
import edu.jsp.foodandrestorent.model.Items;

public class ViewClass {
	
	static {
		
		System.out.println("------------WELCOME TO SHOP-------------");
	}
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		Scanner read = new Scanner(System.in) ;
		
		Customer customer = new Customer() ;
		
		boolean loop = true ;
		
		System.out.println("Please add A customer");
		
		System.out.println("Enter the Customer ID");
		int id = read.nextInt() ;
		System.out.println("Enter the Customer Name");
		read.nextLine() ;
		String name = read.nextLine() ;
		System.out.println("Enter the Address");
		String address = read.nextLine() ;
		System.out.println("Enter the phone Number");
		long phno = read.nextLong() ;
		
		customer.setCustomerId(id);
		customer.setCustomerName(name);
		customer.setAdderss(address);
		customer.setPhno(phno);
		
		while (loop) {
			
			System.out.println("Select the Operation you want to Perform \n1. Add Items and items \n2. Find Item By ID "
					+ "\n3. Update item Name \n4. Delete item \n5. Get all items Customer \n0. exit");
			
			int operation = read.nextInt() ;
			
			Items resultProduct;
			switch (operation) {
			case 1 :
				System.out.println("Now add the Items Needed");
				
				ArrayList<Items> listofItems = new ArrayList<Items>() ;
				System.out.println("Select the Item And The Quantity \n1. Rice - 50KG \n2. Mix Vegitables - 100KG \n3. Juice -100 \n4. cake - 50 \n5. Exit");
				boolean loop1 = true ;
				while (loop1) {
					
					Items items = new Items() ;
					
					int choice = read.nextInt() ;
					switch (choice) {
					case 1:
						System.out.println("Enter the quantity ");
						int quant = read.nextInt() ;
						System.out.println("total price of item is :"+ 50*quant);
//						System.out.println("Do you want to add \n Yes \n No");
						String ans = read.next() ;
//						if (ans.equalsIgnoreCase("yes")) {
							items.setItemId(1001);
							items.setItemName("Rice");
							items.setQuantity(quant);
							items.setPrice(50*quant);
//						}
						break;
					case 2:
						System.out.println("Enter the quantity ");
						int quant2 = read.nextInt() ;
						System.out.println("total price of item is :"+ 100*quant2);
//						System.out.println("Do you want to add \n Yes \n No");
//						String ans1 = read.next() ;
//						if (ans1.equalsIgnoreCase("yes")) {
							items.setItemId(1002);
							items.setItemName("Mix Vegitables");
							items.setQuantity(quant2);
							items.setPrice(100*quant2);
//						}
						break;
					case 3:
						System.out.println("Enter the quantity ");
						int quant3 = read.nextInt() ;
						System.out.println("total price of item is :"+ 100*quant3);
//						System.out.println("Do you want to add \n Yes \n No");
//						String ans2 = read.next() ;
//						if (ans2.equalsIgnoreCase("yes")) {
							items.setItemId(1003);
							items.setItemName("Juice");
							items.setQuantity(quant3);
							items.setPrice( 100*quant3);
//						}
						break;
					case 4:
						System.out.println("Enter the quantity ");
						int quant4 = read.nextInt() ;
						System.out.println("total price of item is :"+ 50*quant4);
//						System.out.println("Do you want to add \n Yes \n No");
//						String ans3 = read.next() ;
//						if (ans3.equalsIgnoreCase("yes")) {
							items.setItemId(1004);
							items.setItemName("cake");
							items.setQuantity(quant4);
							items.setPrice(50*quant4);
//						}
						break;
						
					case 5:
						loop1 = false ;
						break ;

					default:
						System.out.println("Select the Any One operation from the Above");
						break;
					}
					
				    
				    listofItems.add(items) ;
				    
				}
				
				
				customer.setItemsList(listofItems);
				System.out.println();
				
				double total = controller.save(customer) ;
				
				System.out.println("Total price is : "+ total);
				
				break;
				
			case 2 :
				
				System.out.println("Enter the Item name to find ");
				String findName = read.next() ;
				Items resultItem = controller.findItem(findName) ;
				System.out.println("Item ID : "+resultItem.getItemId());
				System.out.println("Item Name : "+resultItem.getItemName());
				System.out.println("Item Quantity : "+resultItem.getQuantity());
				System.out.println("Item Price : "+resultItem.getPrice());
				System.out.println();
				break ;
			case 3 :
				System.out.println("Enter the Item name to update ");
				String updatename = read.next() ;
				System.out.println("Enter the Quantity ");
				int updateQuantity = read.nextInt() ;
				controller.updateItemByName(updatename, updateQuantity);
				System.out.println("Item Updated");
				break ;
			case 4:
				System.out.println("Enter the name of the Items you wanna Delete ");
				String deleteName = read.next() ;
				controller.deleteItem(deleteName);
				System.out.println("Item Deleted...");
				break ;
			case 5 :
				List<Items> items = controller.findAllItems() ;
				for (Items items2 : items) {
					
					System.out.println("Item ID : "+items2.getItemId());
					System.out.println("Item Name : "+items2.getItemName());
					System.out.println("Item Quantity : "+items2.getQuantity());
					System.out.println("Item Price : "+items2.getPrice());
					System.out.println();
				}
				break;
			case 0:
				loop = false ;
				break ;
				default :
					System.out.println("Select the Correct Operation ");
					break ;
			}
		}
	}
}
