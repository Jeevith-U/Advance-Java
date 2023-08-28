package edu.tyss.oneToMany_Example1.View;

import java.util.Arrays;
import java.util.List;

import edu.tyss.oneToMany_Example1.Controller.Controller;
import edu.tyss.oneToMany_Example1.model.Phone;
import edu.tyss.oneToMany_Example1.model.Sim;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createPhoneAndSim(controller) ;
		
//		controller.findAllSims(1102);
		
//		controller.portSim(1102, 54251, "vi");
		
		controller.removeSim(1102, 54251);
	}

	public void createPhoneAndSim(Controller controller) {
		
		Phone phone = new Phone() ;
		phone.setId(1102);
		phone.setName("iPhone");
		phone.setPrice(67000);
		
		Sim sim = new Sim() ;
		sim.setId(2165);
		sim.setName("Airtel");
		sim.setNumber(987654434);
		
		Sim sim2 = new Sim() ;
		sim2.setId(54251);
		sim2.setName("Gio");
		sim2.setNumber(612767238);
		
		List<Sim> list = Arrays.asList(sim, sim2) ;
		
		phone.setSims(list);
		
		controller.savePhone(phone);
		System.out.println("added....");
		
	}
}
