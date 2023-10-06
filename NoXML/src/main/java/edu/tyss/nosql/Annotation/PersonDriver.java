package edu.tyss.nosql.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonDriver {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext annotationContex = new AnnotationConfigApplicationContext(MyConfiguration.class) ;
		
		Person person = (Person)annotationContex.getBean("person") ;
		
		person.eat();
	}
}
