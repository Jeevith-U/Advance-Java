package edu.jsp.encryptionanddecryption.view;

import java.util.Scanner;

import edu.jsp.encryptionanddecryption.bean.User;
import edu.jsp.encryptionanddecryption.controller.UserController;

public class UserView {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in) ;
		
		UserController controller = new UserController() ;
		
		boolean flag = true ;
		while (flag) {
			System.out.println("Select the Opeation that you want to perform \n1. Add User \n2. Find User By ID \n3. Update User By ID \n4. Delete User By ID \n0. Exit ");
			int operation = scan.nextInt() ;
			
			switch (operation) {
			case 1:
				addUser(scan, controller) ;
				
				break;
			case 2:
				findAndPrintUser(scan, controller) ;
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 0:
				flag = false ;
				break;

			default:
				break;
			}
		}
	}

	private static void findAndPrintUser(Scanner scan, UserController controller) {
		
		System.out.println("Enter the user ID");
		int id = scan.nextInt() ;
		System.out.println("Enter the Password");
		String password = scan.next() ;
		User user = controller.findUserById(id, password) ;
		
		System.out.println("User Id : "+user.getId());
		System.out.println("User Name :"+user.getName());
		System.out.println("User Email :"+user.getEmail());
		System.out.println("User password :"+user.getPassword());
		System.out.println();
		
	}

	private static void addUser(Scanner scan, UserController controller) {
		
		User user = new User() ;
		
		System.out.println("Enter the User id");
		int id = scan.nextInt();
		System.out.println("Enter the User Name");
		String name = scan.next() ;
		System.out.println("Enter the User Email");
		String email = scan.next() ;
		System.out.println("Enter the User Password");
		String password = scan.next() ;
		
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		controller.saveUser(user);
	}
}
