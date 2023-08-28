package ManyToOne_Example2.Controll;

import ManyToOne_Example2.Model.ElectronicDevice;
import ManyToOne_Example2.Model.Person;

public class View {
	
	public static void main(String[] args) {
		
		Controll controll = new Controll() ;
		
		View view = new View() ;
		
//		view.create(controll);
		
//		controll.findPerson(121);
		
//		controll.updateName(121, 53643);
		
		controll.deleteDevice(121);
		
		
	}

	public void create(Controll controll) {
		
		ElectronicDevice device  = new  ElectronicDevice() ;
		device.setId(121);
		device.setName("Mobile");
		device.setPrice(15400);
		
		Person person = new Person() ;
		person.setId(231);
		person.setName("Jee");
		
		device.setPerson(person);
		
		controll.save(device);
		System.out.println("Added..");
		
	}
}
