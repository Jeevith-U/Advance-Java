package com.tyss.AnnotationInInterface.variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	String name = "pavan" ;
	
	@Autowired
	@Qualifier(value = "vegFood") 
	Food food ;
	
	public void presenting() {
		
		food.cutting();
	}
}
