package com.tyss.userdetails.model;

import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tyss.userdetails.configuration.MyConfiguration;

public class TestUsers {
	
	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in) ;
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class) ;
		
		EntityManagerFactory emf = (EntityManagerFactory)context.getBean("entitymanagerfactory") ;
		EntityManager em = (EntityManager)context.getBean("entitymanager") ;
		EntityTransaction et = (EntityTransaction)context.getBean("entitytransaction") ;
		
		Users user = (Users)context.getBean("users") ;
		
		boolean flag = true ;
		
		while (flag) {
			
			System.out.println("Hey "+user.getName()+" what you wanna Book \n1. Flight \n2. Accommodations \n0. Exit");
			
			int res = read.nextInt() ;
			
			if (res == 1) {
				
				bookFlight(user, emf, em,et, context) ;
			}
			else if (res== 2) {
				bookAccommodation(user, emf, em,et, context) ;
			}else
				flag = false ;
			
				System.out.println("🙏 Thanks For Using JeevaBooking.io ");
		}
	}

	private static void bookAccommodation(Users user, EntityManagerFactory emf, EntityManager em, EntityTransaction et,
			AnnotationConfigApplicationContext context) {
		
	       Accommodation hotel = (Accommodation)context.getBean("accommodation") ;
	       
	       System.out.println(hotel);
		
		if (user.getBalance() > hotel.getPrice()) {
			
			System.out.println("if con");
			
			double bal = user.getBalance() - hotel.getPrice() ;
			
			System.out.println("Congradulations Your Hotel is Booked..");
			et.begin();
			
			user.setAccommodationList(Arrays.asList(hotel));
			
			hotel.setUsers(user);
			
			user.setBalance(bal);
			em.merge(user);
			et.commit();
			
			System.out.println("Data Saved..👍");
		}
		else
			System.out.println("You have insufficent Balance in You account");
	}

	public static void bookFlight(Users user, EntityManagerFactory emf, EntityManager em, EntityTransaction et, AnnotationConfigApplicationContext context) {
		
		  Flight flight = (Flight)context.getBean("flight") ;
		  

			if (user.getBalance() > flight.getPrice()) {
				
				Double bal = user.getBalance() -  flight.getPrice() ;
				
				System.out.println("Congradulations you Ready to fly");
				
				et.begin();
				
				user.setFlightList(Arrays.asList(flight));
				
				flight.setUsers(user);
				user.setBalance(bal);
				em.merge(user);
				et.commit();
				
				System.out.println("Data Saved..👍");
			}
			else
				System.out.println("You have insufficent Balance in You account");
	}

	
}
