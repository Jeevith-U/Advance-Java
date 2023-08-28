package edu.tyss.manytomanyexample1.Dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.tyss.manytomanyexample1.Model.Student;
import edu.tyss.manytomanyexample1.Model.Subject;

public class StudentAndSubjectController2 {
	
public static void main(String[] args) {
	
	
	/*
	 * In this program i am trying to assign a existing subject to a new student
	 * inorder to do that i don't have to create a new subject instead of that i can use the existing subject
	 * Event i want to do vice-versa add subject to existing student
	 * 
	 */
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
	/*	Student student = new Student() ;
		
		student.setId(201);
		student.setName("akash");
		student.setEmail("akash@gmail.com");
		
		Subject exsistingSubjet = entityManager.find(Subject.class, 2023101) ;
		
		Subject subject = new Subject() ;
		
		subject.setId(2023103);
		subject.setName("Docker");
		subject.setDays(30);
		
		List<Subject> list = Arrays.asList(exsistingSubjet, subject) ;
		
		student.setSubjects(list);
		
		entityTransaction.begin();
		entityManager.persist(student);
		entityManager.persist(subject);
		entityTransaction.commit();
		
		*/
		
		/*
		 * this if to find a student 
		 * 
		 */
		
		Student stud = entityManager.find(Student.class, 101) ;
		
		System.out.println("Student Name : "+stud.getName());
		System.out.println("Student ID : "+stud.getId());
		System.out.println("Student Email : "+stud.getEmail());
		System.out.println("Student Subjects Are :- ");
		System.out.println();
		List<Subject> sub = stud.getSubjects() ;
		
		for (Subject subject : sub) {
			
			System.out.println("Subject Id : "+subject.getId());
			System.out.println("Subject Name : "+subject.getName());
			System.out.println("Subject Days : "+subject.getDays());
			System.out.println();
		}
    }
}
