package edu.tyss.onetoone_example4.View;

import edu.tyss.onetoone_example4.Controller.Controller;
import edu.tyss.onetoone_example4.model.Car;
import edu.tyss.onetoone_example4.model.RegistrastionDetails;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createCar(controller) ;
		
//		controller.findCarDetails("KA02MA4528") ;
		
		controller.updateCarDetails("KA02MA4528", "1st Hand");
	}

	public void createCar(Controller controller) {
		
		Car car = new Car() ;
		
		car.setCarNumber("KA02MA4528");
		car.setColor("Grey");
		car.setPrice(240000);
		
		RegistrastionDetails details = new RegistrastionDetails() ;
		details.setId(4528);
		details.setName("Maruti");
		details.setOwnerShip("2nd");
		
		car.setDetails(details);
		
		controller.saveCarDetails(car);
		System.out.println("Saved...!");
		
	}
}
