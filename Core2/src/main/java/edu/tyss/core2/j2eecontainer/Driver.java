package edu.tyss.core2.j2eecontainer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.tyss.core2.model.Phone;

public class Driver {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml") ;
		Phone phone = (Phone)context.getBean("myphone") ;
		phone.photo();;
	}
}
