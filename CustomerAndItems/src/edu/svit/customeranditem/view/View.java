	package edu.svit.customeranditem.view;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.ResourceBundle.Control;
	import java.util.Scanner;
	
	import edu.svit.customeranditem.controller.Controller;
	import edu.svit.customeranditem.model.Customer;
	import edu.svit.customeranditem.model.Item;
	
	public class View {
		
		public static void main(String[] args) {
			
			Controller controller = new Controller() ;
			
			Scanner scan = new Scanner(System.in) ;
			
			Customer cus = new Customer() ;
			
			System.out.println("Enter the Customer ID");
			
			int id = scan.nextInt() ;
			
			System.out.println("Enter the coustomer name");
			
			String name = scan.next() ;
			
			System.out.println("Enter the phone  Number ");
			
			long phno = scan.nextLong() ;
			
			System.out.println("Enter the customer address");
			
			String address = scan.next() ;
			
			cus.setId(id);
			cus.setName(name);
			cus.setPhoneNumber(phno);
			cus.setAddress(address);
			
			boolean flag = true ;
			
			while (flag) {
				
				System.out.println("1. Add the Items \n2. find item by name \n3. Update Items \n4. Delete Item \n5. Display All \n0. Exit");
				
				int choice = scan.nextInt() ;
				
				ArrayList<Item> listofItems = new ArrayList<Item>() ;
				
				switch (choice) {
				case 1:
					boolean flag3 = true ;
					while (flag3) {
					Item item = new Item() ;
					System.out.println("Enter the Item Id");
					int pid = scan.nextInt() ;
					System.out.println("Enter the Items Name");
					String pname = scan.next() ;
					System.out.println("Enter the price");
					double price = scan.nextDouble() ;
					System.out.println("Enter the Quantity");
					int quantity = scan.nextInt() ;
					
					item.setItemnId(pid);
					item.setItemName(pname);
					item.setQuantity(quantity);
					item.setPrice(price);
					
					listofItems.add(item) ;
					
					
					System.out.println("Do want to add another item");
					String response = scan.next() ;
					if (response.equalsIgnoreCase("yes")) {
						continue ;
					}
					else
						break ;
					}
					cus.setListofItems(listofItems);
					
					controller.addCustomer(cus);
					System.out.println("data inserted...!");
					break;
				case 2:
					System.out.println("Enter the name of item");
					String findName = scan.next() ;
					Item returenedItem = controller.findItemByName(findName) ;
					System.out.println("Item ID : "+returenedItem.getItemnId());
					System.out.println("Item Name : "+returenedItem.getItemName());
					System.out.println("Item Quantity : "+returenedItem.getQuantity());
					System.out.println("Item price : "+returenedItem.getPrice());
					System.out.println();
					break ;
				case 3:
					System.out.println("Enter the Item Name");
					String updatename = scan.next() ;
					System.out.println("Enter the Quantity");
					int updateQuan = scan.nextInt() ;
					
					controller.UpdateItem(updatename, updateQuan);
					
					System.out.println("Item Updated...!");
					break ;
					
				case 4 :
					System.out.println("Enter the Item Name :");
					String delname = scan.next() ;
					controller.deleteItem(delname);
					System.out.println("Item deleted");	
					break ;
					
				case 5:
					List<Item> items = controller.displayAll() ;
					for (Item item2 : items) {
						
						System.out.println("Item ID : "+item2.getItemnId());
						System.out.println("Item Name : "+item2.getItemName());
						System.out.println("Item Quantity : "+item2.getQuantity());
						System.out.println("Item price : "+item2.getPrice());
						System.out.println();
					}
					break ;
				case 0 :
					flag = false ;
				default:
					break;
				}
			}
		}
	}
