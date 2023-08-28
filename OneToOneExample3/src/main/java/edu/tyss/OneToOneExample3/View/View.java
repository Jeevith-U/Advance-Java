package edu.tyss.OneToOneExample3.View;

import edu.tyss.OneToOneExample3.controller.Controller;
import edu.tyss.OneToOneExample3.model.Remote;
import edu.tyss.OneToOneExample3.model.Telivision;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createTvAndRemote(controller) ;
		
//		controller.findDetails(235);
		
//		controller.updateRemoteDetails(235, "SuperSony");
		
		controller.deleteTelivision(235);
	}

	public void createTvAndRemote(Controller controller) {
		
		Telivision telivision = new Telivision() ;
		
		telivision.setId(235);
		telivision.setBrandName("Sony");
		telivision.setPrice(440000);
		
		Remote remote = new Remote() ;
		
		remote.setBrand("Sony");
		remote.setId(235121);
		remote.setPrice(1299);
		
		telivision.setRemote(remote);
		
		controller.saveTelivision(telivision);
		
		System.out.println("Addedd");
		
	}
}
