package View;

import Dto.Controller;
import Model.Person;
import Model.Vehicle;

public class View {

	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.create(controller) ;
		
//		controller.findVehicle(101);
		
		controller.updateName(101, "Tractor");
		
		controller.deleteVehicle(101);
		
	}

	private void create(Controller controller) {

//		Vehicle vehicle = new Vehicle();
//
//		vehicle.setId(101);
//		vehicle.setVehicle("Bike");
//		vehicle.setPrice(190000);

		Person person = new Person();

		person.setId(20101);
		person.setName("Jeevith");

//		vehicle.setPerson(person);
//
//		controller.save(vehicle);

		Vehicle vehicle1 = new Vehicle();

		vehicle1.setId(101);
		vehicle1.setVehicle("Car");
		vehicle1.setPrice(590000);
		
		vehicle1.setPerson(person);
		controller.save(vehicle1);

		System.out.println("Added..");

	}
}
