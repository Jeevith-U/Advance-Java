package Controller;

import java.util.List;

import Model.Student;
import Model.University;

public class ControllUS {
	
	University university= new University() ;
	
	public void saveUniversity(University uni) {
		
		university  = uni ;
	}
	
	public void findStudent(int id) {
		List<Student> students = university.getListofStudents() ;
		
		for (Student student : students) {
			
			if (student.getSid() == id) {
				
				System.out.println("Student Name : "+student.getSname());
				System.out.println("Student ID : "+student.getSid());
				
			}
		}
	}
	
	public void updateStudent(int sid, String newName) {
		
		List<Student> listofStudent = university.getListofStudents() ;
		
		for (Student student : listofStudent) {
			
			if (student.getSid() == sid ) {
				
				student.setSname(newName);
			}
		}
	}
	
	
	public void deleteStudent(int id) {
		
		List<Student> students = university.getListofStudents() ;
		
		Student delStudent = null ;
		for (Student student : students) {
			
			if (student.getSid() == id) {
				delStudent = student ;
			}
		}
		
		students.remove(delStudent) ;
	}
	
	public void displayAll() {
		
		List<Student> students = university.getListofStudents() ;
		
		for (Student student : students) {
			
			System.out.println("Student Name : "+student.getSname());
			System.out.println("Student ID : "+student.getSid());
			System.out.println();
		}
	}
	
}
