package edu.tyss.OneToOneExample2.View;

import edu.tyss.OneToOneExample2.Controller.Controller;
import edu.tyss.OneToOneExample2.model.IdCard;
import edu.tyss.OneToOneExample2.model.Person;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createPersonAndIdcard(controller) ;
		
//		controller.findIdCard(234);
		
//		controller.UpdateIdCard(234, "TYSS");
		
		controller.deleteId(234);
	}

	public void createPersonAndIdcard(Controller controller) {
		
		Person person = new Person() ;
		
		person.setId(234);
		person.setName("Jeevith");
		person.setPhno(73647436);
		
		IdCard card = new IdCard() ;
		
		card.setId(23436);
		card.setName("Tyss");
		card.setIdType("permanent");
		
		person.setIdCard(card);
		
		controller.savePerson(person);
		
		System.out.println("Added Successfully");
		
		
	}
}
