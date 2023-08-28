package edu.jsp.hibernate_practice1.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CRUD {
	
	public static void main(String[] args) {
		
		Teacher teacher = new Teacher() ;
		teacher.setTeacherId(101);
		teacher.setTeacherName("Balaya");
		teacher.setTeacherSubject("Biology");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jeevith") ;
		EntityManager maneger = emf.createEntityManager() ;
		EntityTransaction transaction = maneger.getTransaction() ;
		
		transaction.begin(); //to begin the transaction 
		maneger.persist(teacher); // to save this object to row in the db 
		transaction.commit(); 
		System.out.println("Teacher saved");
		
	}
}
