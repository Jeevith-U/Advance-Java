package View;

import Controller.Controller;
import Model.Brand;
import Model.Service;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.create(controller) ;
		
		controller.findVehi(101);
		
//		controller.updateBrand(101, "Mysore");
		
		controller.deleteBrand(101);
	}

	private void create(Controller controller) {
		
		Brand brand = new Brand() ;
		
		brand.setId(101);
		brand.setName("Hero");
		brand.setYears(12);
		
//		service1 service1 = new service1() ;
//		service1.setId(10112);
//		service1.setName("yalahanka");
//		service1.setPincode(571022);
		
		Service service1 = new Service() ;
		service1.setId(10113);
		service1.setName("Hebbal");
		service1.setPincode(571453);
		
		brand.setServices(service1);
		controller.save(brand);
		System.out.println("Added..");
		
	}
}
