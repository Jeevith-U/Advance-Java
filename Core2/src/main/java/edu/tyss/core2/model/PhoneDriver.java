package edu.tyss.core2.model;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class PhoneDriver {
	
	public static void main(String[] args) {
		
		/*	ClassPathResource resource = new ClassPathResource("config.xml") ;
		
		XmlBeanFactory factory = new XmlBeanFactory(resource) ;
		
		Phone phone = (Phone)factory.getBean("myphone") ;
		
		phone.photo();*/
		
		/* USING J2EE CONTAINER*
		 */
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml") ;
		 Phone phone = (Phone)context.getBean("myphone") ;
		 phone.photo();
	}
}
