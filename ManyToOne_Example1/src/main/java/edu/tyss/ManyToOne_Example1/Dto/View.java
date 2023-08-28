package edu.tyss.ManyToOne_Example1.Dto;

import edu.tyss.ManyToOne_Example1.model.Paticent;
import edu.tyss.ManyToOne_Example1.model.Reports;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.create(controller) ;
		
//		controller.findReport(121);
		
//		controller.updateReport(121, "Cardio");
		
		controller.deleteReport(121);
		
		
	}

	public void create(Controller controller) {
		
		Reports reports = new Reports() ;
		reports.setId(121);
		reports.setName("Heart");
		reports.setReportName("Cardio Vascular");
		
		Paticent paticent = new Paticent() ;
		paticent.setId(231);
		paticent.setName("jee");
		
		reports.setPaticent(paticent);
		
		controller.save(reports);
		System.out.println("Added...");
		
	}
}
