package com.springdemo.SpringBootdemo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/info")
	public String message() {
		return "ohhh yaa" ;
	}
	
	@GetMapping("/salary")
	public double getMySalary() {
		return 878167.77 ;
	}
	
	@GetMapping("/get")
	public String getMappingMethod() {
		return "Hi This is From Get Mapping" ;
	}
	
	@PostMapping("/test")
	public String postMapping() {
		return "Hi this is from post Method" ;
	}
	
	@DeleteMapping("/delete")
	public String deleteMapping() {
		return "Hi this is from Delete Mapping " ;
	}
	
	@GetMapping("/student")
	public String myInfo(@RequestParam int myId) {
		return "I recived ID : "+myId ;
	}
	
	@PostMapping("/name")
	public String printName(@RequestParam(name = "name")String empname , @RequestParam long salary) {
		
		return " Name is Jeevith And Salary is "+ salary;
	}
}
