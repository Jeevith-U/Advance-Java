package edu.tyss.mtmStudentAndSubjects.Controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.security.auth.Subject;

import edu.tyss.mtmStudentAndSubjects.model.Student;
import edu.tyss.mtmStudentAndSubjects.model.Subjects;

public class Controller {
	
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jeevith") ;
	static EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	static EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	public static void main(String[] args) {
		
		Controller controller = new Controller() ;
		
//		controller.create() ;
		
//		controller.findSubjectsAndStudentOpted() ;
		
//		controller.updateSubjectOfAStudent() ;
		
		controller.deleteSubjectFromStudent() ;
	
	}

	private void deleteSubjectFromStudent() {
		
		Student student = entityManager.find(Student.class, 201) ;
		
		Subjects subject = entityManager.find(Subjects.class, 302) ;
		
		student.getListOfSubList().remove(subject) ;
		
		subject.getListOfStudents().remove(student) ;
		
		Subjects sub=entityManager.find(Subjects.class,302);
		List<Student> std=sub.getListOfStudents();
		std.remove(entityManager.find(Subjects.class, 302)) ;
		
		
		
		entityTransaction.begin();
		
		entityManager.remove(subject);
		
		entityManager.remove(student);
		
		entityTransaction.commit();
		
		System.out.println("Deleted..");
		
	}

	private void updateSubjectOfAStudent() {
		
		Student student = entityManager.find(Student.class, 201) ;
		
		Subjects subject = entityManager.find(Subjects.class, 302) ;
		
		List<Student> studentList = subject.getListOfStudents() ;
		
		List<Subjects> list=student.getListOfSubList();
		list.add(subject);
		student.setListOfSubList(list);
		
		System.out.println(list);
		entityTransaction.begin();
		studentList.add(student) ;
		list.add(subject);
		
		entityManager.merge(student) ;
		entityManager.merge(subject) ;
		entityTransaction.commit();
		
		System.out.println("Updated..!");
		
	}

	private void findSubjectsAndStudentOpted() {
		
		Subjects subject = entityManager.find(Subjects.class, 302) ;
		
		System.out.println(subject.getId());
		System.out.println(subject.getSubjectName());
		System.out.println(subject.getTotalDuration());
		
		System.out.println();
		System.out.println("Number Of Student Opted is :"+subject.getListOfStudents().size());
		List<Student> students = subject.getListOfStudents() ;
		
		for (Student student : students) {
			
			System.out.println(student.getId());
			System.out.println(student.getName());
		}
	}

	private void create() {
		
		Student student = new Student() ;
		
		student.setId(101);
		student.setName("Jeevith");
		
		Student student2 = new Student() ;
		student2.setId(201);
		student2.setName("Pavan");
		
		Subjects subjects1 = new Subjects() ;
		
		subjects1.setId(301);
		subjects1.setSubjectName("Maths");
		subjects1.setTotalDuration(365);
		
		Subjects subjects2 = new Subjects() ;
		
		subjects2.setId(302);
		subjects2.setSubjectName("Physics");
		subjects2.setTotalDuration(300);
		
		Subjects subjects3 = new Subjects() ;
		
		subjects3.setId(303);
		subjects3.setSubjectName("Spring");
		subjects3.setTotalDuration(40);
		
		List<Subjects> listOfsubjects = Arrays.asList(subjects1, subjects2, subjects3) ;
		
		List<Subjects> listOfsubjects1 = Arrays.asList(subjects2, subjects3) ;
		
		student.setListOfSubList(listOfsubjects);
		
		student2.setListOfSubList(listOfsubjects1);
		
//		student2.getListOfSubList().add(subjects1) ;
		
		List<Student> listOfStudent1 = Arrays.asList(student, student2) ;
		
		List<Student> listOfStudent2 = Arrays.asList(student) ;
		
		subjects1.setListOfStudents(listOfStudent1);
		
		subjects2.setListOfStudents(listOfStudent2);
		
		subjects3.setListOfStudents(listOfStudent1);
		
		
		
		
		entityTransaction.begin();
		
		entityManager.persist(student);
		entityManager.persist(student2);
		entityManager.persist(subjects1);
		entityManager.persist(subjects2);
		entityManager.persist(subjects3);
		
		entityTransaction.commit();
		
		System.out.println("Added..");
		
		
	}

}
