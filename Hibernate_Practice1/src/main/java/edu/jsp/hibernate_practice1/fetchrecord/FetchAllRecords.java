package edu.jsp.hibernate_practice1.fetchrecord;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.jsp.hibernate_practice1.Model.Teacher;
import edu.jsp.hibernate_practice1.teacher.NewTeacher;

public class FetchAllRecords {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
		EntityManager manager = entityManagerFactory.createEntityManager() ;
		
		Query query = manager.createQuery("SELECT s FROM NewTeacher s") ;
		
		List<NewTeacher> teachers = query.getResultList() ;
		
		for (NewTeacher teacher : teachers) {
			
			System.out.println(teacher.getTeacherId());
			System.out.println(teacher.getTeacherName());
			System.out.println(teacher.getEmail());
			System.out.println(teacher.getTeacherSubject());
			System.out.println("***************************************");
		}
	}
}
