package edu.tyss.spring_carapp.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml") ;
		
		User user = (User)context.getBean("myuser") ;
		
		System.out.println(user.getId());
		System.out.println(user.getName());
		System.out.println(user.getPhno());
		System.out.println(user.getCar().getId());
		System.out.println(user.getCar().getName());
		System.out.println(user.getCar().getColor());
		System.out.println(user.getCar().getPrice());
		
	}
}
