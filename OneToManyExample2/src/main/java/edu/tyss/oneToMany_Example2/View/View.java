package edu.tyss.oneToMany_Example2.View;

import java.util.Arrays;
import java.util.List;

import edu.tyss.oneToMany_Example2.Controller.Controller;
import edu.tyss.oneToMany_Example2.model.Driver;
import edu.tyss.oneToMany_Example2.model.Uber;

public class View {
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
		View view = new View() ;
		
//		view.createUberAndDriver(controller) ;
		
//		controller.FindAllUberDriver(6253);
		
//		controller.updateDriverName(6253, 2312, "somanna");
		
		controller.deleteDriver(6253, 2312);
	}

	public void createUberAndDriver(Controller controller) {
		
		Uber uber = new Uber() ;
		
		uber.setId(6253);
		uber.setCompanyName("Uber");
		
		Driver driver = new Driver() ;
		driver.setId(1233);
		driver.setName("Mahantesh");
		driver.setDistance(120);
		driver.setPrice(3440);
		
		Driver driver2 = new Driver() ;
		driver2.setId(2312);
		driver2.setName("Yanktanna");
		driver2.setPrice(350);
		driver2.setDistance(20);
		
		List<Driver> drivers = Arrays.asList(driver, driver2) ;
		
		uber.setDrivers(drivers);
		controller.bookUber(uber);
		System.out.println("Added...");
	}
}
