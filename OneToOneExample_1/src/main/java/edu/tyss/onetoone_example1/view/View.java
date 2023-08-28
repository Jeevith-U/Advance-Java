package edu.tyss.onetoone_example1.view;

import edu.tyss.onetoone_example1.Dto.Controller;
import edu.tyss.onetoone_example1.model.FingerPrint;
import edu.tyss.onetoone_example1.model.Person;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createPersonAndFingerPrint(controller) ;
		
//		controller.findFingerPrint(101);
		
//		controller.updateNumberOfPrint(101, 1);
		
		controller.removeFingerPrint(101232);
		
		
	}

	public void createPersonAndFingerPrint(Controller controller) {
		
		Person person = new Person() ;
		person.setId(101);
		person.setName("Jeevith");
		person.setAge(23);
		
		FingerPrint print = new FingerPrint() ;
		
		print.setId(101232);
		print.setNumberofPrint(2);
		print.setType("radial loop");
		
		person.setFingerPrint(print);
		
		controller.savePersonAndFingerPrint(person);
		
		System.out.println("Added...!");
		
	}

}
