package View;

import java.util.Arrays;
import java.util.List;

import Dto.Controller;
import Model.Job;
import Model.Person;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
		view.create(controller) ;
		
		controller.findPersonJob(101);
		
		controller.updateJob(101, 202, "principal Architect");
		
		controller.deleteJob(101, 202);
		
	}

	public void create(Controller controller) {
		
		Person person = new Person() ;
		
		person.setId(101);
		person.setName("Jeevith");
		
		Job job = new Job() ;
		job.setId(201);
		job.setDesignation("Software Developer");
		job.setSal(21660);
		
		Job job2 = new Job() ;
		job2.setId(202);
		job2.setDesignation("Architect");
		job2.setSal(9999999);
		
		List<Job> jobs = Arrays.asList(job,job2) ;
		person.setList(jobs);
		System.out.println("Added...");
	}
}
