package com.pathvariable.PathVariable.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	
	@GetMapping("/profile/{id}")
	public String proInfo(@PathVariable int id) {
		return "Id is "+id ;
	}
	
	@PostMapping("/details/{id}/{name}")
	public String details(@PathVariable int id, @PathVariable String name) {
		return "Id is : "+id+ " Name is "+ name ;
	}
	
	@GetMapping("/getToken")
	public String tokenDetails(@RequestHeader String token ) {
		return "My token Is : " + token;
	}
	
	@GetMapping("/map")
	public HashMap<String, Integer> getDataFromMap(){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>() ;
		
		map.put("J", 23) ;
		map.put("N", 21) ;
		map.put("s", 22) ;
		map.put("A", 24) ;
		return map;
		
	}
}
