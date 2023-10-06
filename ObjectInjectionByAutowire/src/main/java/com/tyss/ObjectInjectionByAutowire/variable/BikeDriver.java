package com.tyss.ObjectInjectionByAutowire.variable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikeDriver {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class) ;
		
		Bike bike = (Bike)context.getBean("bike") ;
		
		bike.display();
	}
}
