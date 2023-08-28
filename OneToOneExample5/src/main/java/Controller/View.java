package Controller;

import Model.Person;
import Model.VoterId;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
		view.create(controller) ;
		
		controller.findPersonDetails(202);
		
		controller.updatePersonDetails(202, "Jeevith U");
		
		controller.deletePerson(202);
		
		
	}

	public void create(Controller controller) {
		
		Person person = new Person() ;
		
		person.setId(202);
		person.setName("Jeevith");
		person.setAge(23);
		
		VoterId voterId = new VoterId() ;
		
		voterId.setCardNum(83253);
		voterId.setState("Banglore");
		
		person.setVoterId(voterId);
		
		controller.savevoterIdDetails(person);
		System.out.println("Addedd..");
		
		
	}
}
