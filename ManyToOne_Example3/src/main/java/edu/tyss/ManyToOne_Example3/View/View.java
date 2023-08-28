package edu.tyss.ManyToOne_Example3.View;

import edu.tyss.ManyToOne_Example3.Controll.Controll;
import edu.tyss.ManyToOne_Example3.model.Address;
import edu.tyss.ManyToOne_Example3.model.Person;

public class View {

	public static void main(String[] args) {
		
		Controll controll = new Controll() ;
		
		View view = new View() ;
		
//		view.create(controll) ;
		
//		controll.findAddress(571426);
		
//		controll.updateAddress(571426, "K R Pet");
		
		controll.deleteAddress(571426);
	}

	private void create(Controll controll) {
		
		Address address = new Address() ;
		
		address.setPincode(571426);
		address.setName("Krishnarajapet");
		
		Person person = new Person() ;
		
		person.setId(22);
		person.setName("Jeevith");
		
		address.setPerson(person);
		System.out.println("Added..");
	}
}
