package com.tyss.AnnotationInInterface.variable;

import org.springframework.stereotype.Component;

@Component
public class VegFood implements Food{

	public void cutting() {
		
		System.out.println("We are cutting vegitables to prepare a veg food");
	}
	
	

}
