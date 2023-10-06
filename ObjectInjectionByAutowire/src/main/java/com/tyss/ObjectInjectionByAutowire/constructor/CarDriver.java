package com.tyss.ObjectInjectionByAutowire.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarDriver {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class) ;
		
		Car car = (Car)context.getBean("car") ;
		
		car.display();
	}
}
