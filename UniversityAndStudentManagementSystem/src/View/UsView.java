package View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Controller.ControllUS;
import Model.Student;
import Model.University;

public class UsView {
	
	public static void main(String[] args) {
		
		ControllUS controllUS = new ControllUS() ;
		
		Scanner scanner = new Scanner(System.in) ;
		
		boolean flag = true ;
		
		while (flag) {
			
			System.out.println("1. Instert Student \n2. Find Student \n3. Update Student Name \n4. Delete Student By ID \n5. Find All Student ");
			
			int choice = scanner.nextInt() ;
			
			switch (choice) {
			case 1:
				
				University university =new University() ;
				
				System.out.println("Enter the University Number");
				int unum = scanner.nextInt() ;
				System.out.println("Enter the University name");
				String uname = scanner.next() ;
				System.out.println("Enter the Number of Students");
				int students = scanner.nextInt() ;
				
				university.setUid(unum);
				university.setUname(uname);
				
				ArrayList<Student> listOfStudents = new ArrayList<Student>() ;
				
				for (int i = 0; i < students ; i++) {
					
					Student student = new Student() ;
					
					System.out.println("Enter the Student ID");
					int sid = scanner.nextInt() ;
					System.out.println("Enter the Student Name");
					String sname = scanner.next() ;
					
					student.setSid(sid);
					student.setSname(sname);
					
					listOfStudents.add(student) ;
				}
				university.setListofStudents(listOfStudents);
				controllUS.saveUniversity(university);
				System.out.println("Student Added...!");
				break;
			case 2:
				System.out.println("Enter the Student id");
				int fid = scanner.nextInt() ;
				controllUS.findStudent(fid);
				break ;
			case 3:
				System.out.println("Enter the Student Id ");
				int upid = scanner.nextInt() ;
				System.out.println("Enter the New Name ");
				String upName = scanner.next() ;
				controllUS.updateStudent(upid, upName);
				System.out.println("Updated Successfully...!");
				break ;
			case 4:
				System.out.println("Enter the student Id");
				int did = scanner.nextInt() ;
				controllUS.deleteStudent(did);
				System.out.println("Data Deleted..!");
				break ;
			case 5:
				controllUS.displayAll();
			default:
				System.out.println("Select the Proper Operation ");
				break;
			}
		}
	}
}
