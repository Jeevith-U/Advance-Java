package edu.tyss.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Car {
	
	@GetMapping("/car1")
	public String marutiCar() {
		return "maruti.jsp" ;
	}
	
	@GetMapping("/car2")
	public String rollsRoys() {
		return "rollsRoys.jsp" ;
	}
	
	@GetMapping("car3")
	public String audi() {
		return "audi.jsp" ;
	}

}
