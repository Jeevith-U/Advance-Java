package edu.jsp.hibernate_practice1.teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestTeacherInsertion {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith");
		EntityManager maneger = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = maneger.getTransaction();

		NewTeacher teacher = new NewTeacher();
		teacher.setTeacherId(10692);
		teacher.setTeacherName("John");
		teacher.setTeacherSubject("English");
		teacher.setEmail("jaknalliOregowdahendrubatiNagaraju@gmail.com");

		transaction.begin();
		maneger.persist(teacher);
		transaction.commit();
		System.out.println("Data Saved..");

	}
}
