package edu.tyss.personandaccounts.View;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import edu.tyss.personandaccounts.Dto.Controller;
import edu.tyss.personandaccounts.model.Person;
import edu.tyss.personandaccounts.model.SocialMediaAccount;

public class PersonAndAccountView {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		Scanner scanner = new Scanner(System.in) ;
		
		PersonAndAccountView view = new PersonAndAccountView() ;
		
	/*	controller.addPersonAndAccounts(createPersonAndAccounts());
		System.out.println("Person And His Social Media Accounts Are Added...!"); */
		
//		view.findPersonAccount(scanner, controller) ;
		
//		view.updateDetails(scanner, controller) ;
		
//		view.deleteAccount(scanner, controller) ;
		
		
		
		
	}

	public void deleteAccount(Scanner scanner, Controller controller) {
		
		System.out.println("Enter the Accout Id That you want Delete");
		int id = scanner.nextInt() ;
		System.out.println("Enter the Account Id");
		int aid = scanner.nextInt() ;
		controller.deletAccount(id,aid);
		System.out.println("Account deleted Sucessfully..");
		
	}

	public void updateDetails(Scanner scanner, Controller controller) {
		
		System.out.println("Enter the Account ID you Want to Update");
		int id = scanner.nextInt() ;
		System.out.println("Enter the Updated Number of Fallowes 😎😎");
		scanner.nextLine() ;
		int fallowers = scanner.nextInt() ;
		
		controller.updateAccountName(id, fallowers);
		
		System.out.println("Fallowers Count Updated....!");
		
	}

	public void findPersonAccount(Scanner scanner, Controller controller) {
		
		System.out.println("Enter the Account ID You Want To find ");
		int id = scanner.nextInt() ;
		SocialMediaAccount account = controller.findAccountById(id);
		System.out.println("Account Id : "+account.getId());
		System.out.println("Account Id : "+account.getName());
		System.out.println("Account Id : "+account.getFollowers());
		
	}

	public static Person createPersonAndAccounts() {
		
		Person person = new Person() ;
		person.setId(232023);
		person.setName("Instaram");
		person.setPhno(999876542);
		
		SocialMediaAccount account1 = new SocialMediaAccount() ;
		account1.setId(65101);
		account1.setName("Instagram");
		account1.setFollowers(672);
		
		SocialMediaAccount account2 = new SocialMediaAccount() ;
		account2.setId(65202);
		account2.setName("FaceBook");
		account2.setFollowers(8923);
		
		List<SocialMediaAccount> list = Arrays.asList(account1, account2) ;
		
		person.setAccounts(list);
		
		return person ;
	}
}
