package com.tyss.AnnotationInInterface.variable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonDriver {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class) ;
		
		Person person = (Person)context.getBean("person") ;
		
		person.presenting();
	}
}
