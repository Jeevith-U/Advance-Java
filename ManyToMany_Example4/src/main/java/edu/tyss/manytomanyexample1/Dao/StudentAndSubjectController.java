package edu.tyss.manytomanyexample1.Dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.manytomanyexample1.Model.Student;
import edu.tyss.manytomanyexample1.Model.Subject;

public class StudentAndSubjectController {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Student student2 = new Student() ;
		
		student2.setId(202);
		student2.setName("Akash");
		student2.setEmail("a.com");
		
		Subject subject = new Subject() ;
		
		subject.setId(2023101);
		subject.setName("Spring");
		subject.setDays(45);
		
		Subject subject1 = new Subject() ;
		
		subject1.setId(2023102);
		subject1.setName("Cloud Computing");
		subject1.setDays(60);
		
		List<Subject> subjects = new ArrayList<Subject>() ;
		
		subjects.add(subject) ;
		subjects.add(subject1) ;
		
		/*
		 * we can add like this also 
		  List<Subject> list = Arrays.asList(subject, subject1) ;
		 */
		
		student2.setSubjects(subjects);
		
		entityTransaction.begin();
		entityManager.persist(student2);
		entityManager.persist(subject);
		entityManager.persist(subject1);
		entityTransaction.commit();
		
	}
}
