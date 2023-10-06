package Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDriver {
	
	public static void main(String[] args) {
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotationconfiguration.xml") ;
		 
		 Person person = (Person)context.getBean("person") ;// class name starts with small letter
		 
		 person.running();
		 
	}
}
