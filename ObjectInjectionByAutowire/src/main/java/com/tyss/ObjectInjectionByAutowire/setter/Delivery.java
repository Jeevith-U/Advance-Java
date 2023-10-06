package com.tyss.ObjectInjectionByAutowire.setter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Delivery {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class) ;
		
		FoodOrder order = (FoodOrder)context.getBean("foodOrder") ;
		
		System.out.println(order);
	}

}
