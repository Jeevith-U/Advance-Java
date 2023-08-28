package edu.jsp.hibernate_practice1.fetchrecord;

import java.util.InputMismatchException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.jsp.hibernate_practice1.teacher.NewTeacher;

public class FetchDataAndUpdateDataAndDelet {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		NewTeacher result = entityManager.find(NewTeacher.class, 10112);

		if (result != null) {
			System.out.println(result);
			System.out.println();
			System.out.println(result.getTeacherId());
			System.out.println(result.getTeacherName());
			System.out.println(result.getEmail());
			System.out.println(result.getTeacherSubject());
		} else {
			throw new InputMismatchException("Check The ID");
		}

		result.setTeacherSubject("BhouthaShastra");

		entityTransaction.begin();
		entityManager.merge(result);
		entityTransaction.commit();

		NewTeacher result2 = entityManager.find(NewTeacher.class, 10112);

		System.out.println();
		System.out.println("After Updation...");
		if (result2 != null) {
			System.out.println(result2);
			System.out.println();
			System.out.println(result2.getTeacherId());
			System.out.println(result2.getTeacherName());
			System.out.println(result2.getEmail());
			System.out.println(result2.getTeacherSubject());
		} else {
			throw new InputMismatchException("Check The ID");
		}
		
		entityTransaction.begin();
		entityManager.remove(result2);
		entityTransaction.commit(); 
		System.out.println("Deleted Successfully");

	}
}
