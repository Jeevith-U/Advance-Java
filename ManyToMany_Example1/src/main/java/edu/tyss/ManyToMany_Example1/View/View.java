package edu.tyss.ManyToMany_Example1.View;

import java.util.Arrays;
import java.util.List;

import edu.tyss.ManyToMany_Example1.dto.Controller;
import edu.tyss.ManyToMany_Example1.model.Account;
import edu.tyss.ManyToMany_Example1.model.Person;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.create(controller) ;
		
//		controller.findAccount(1023);
		
//		controller.updateAccount(1023, 4352, 6254273);
		
		controller.deleteAccount(1023, 4352);
		
	}

	public void create(Controller controller) {
		
		Person person = new Person() ;
		
		person.setId(1023);
		person.setName("Jeevith");
		
		Account account = new Account() ;
		
		account.setId(4352);
		account.setBank("BOB");
		account.setAccoutType("Savings");
		account.setBalance(876543);
		
		Account account2 = new Account() ;
		
		account2.setId(675);
		account2.setBank("SBI");
		account2.setAccoutType("Busniess");
		account2.setBalance(987654445);
		
		List<Account> list = Arrays.asList(account, account2) ;
		
		person.setAccounts(list);
		
		controller.save(person);
		System.out.println("added...");
		
	}
}
