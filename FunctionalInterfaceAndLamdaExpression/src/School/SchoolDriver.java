package School;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SchoolDriver {
	
	public static void main(String[] args) {
		
		School school = new School() ;
		
		school.setId(1);
		school.setName("VVIT");
		school.setAddress("Banglore Karnataka");
		
		List<Student> studentList = new ArrayList<Student>() ;
		
		studentList.add(new Student(101, "Jeevith1", 23, "17Th")) ;
		studentList.add(new Student(107, "Jeevith2", 18, "12")) ;
		studentList.add(new Student(109, "Jeevith3", 20, "14th")) ;
		studentList.add(new Student(103, "Jeevith4", 21, "15")) ;
		studentList.add(new Student(105, "Jeevith5", 20, "14")) ;
		studentList.add(new Student(102, "Jeevith6", 17, "12")) ;
		
		school.setStudentList(studentList);
		
		HashSet<Student> setstudent = new HashSet<Student>(studentList) ; 
		
		List<Student> studentList2 = new ArrayList<Student>() ;
		studentList2.add(new Student(203, "BalayaGaru", 23, "17Th")) ;
		studentList2.add(new Student(234, "Narashima", 18, "12")) ;
		studentList2.add(new Student(286, "salman", 20, "14th")) ;
		studentList2.add(new Student(212, "Ganesh", 21, "15")) ;
		
		School school2 = new School(2, "BGS", "Chunchanagiri", studentList2) ;
		
		List<School> schoolList = new ArrayList<School>() ;
		
		/*
		 * Operations Performing On school list Using Stram API
		 * Total Number Of Student From Both School,Oldest Student, Youngest Student, Student Above 21
		 
		
		 School sco = schoolList.stream().max((s1, s2) -> (int)s1.getStudentList().size() - (int)s2.getStudentList().size()).get() ;
		System.out.println("The School Which Containe Maxminu Student IS : "+sco.getName()); */
		
		List<Student> students = school.getStudentList() ;
		Student maxAge = students.stream().max((s11, s22) -> (int)s11.getAge() - (int) s22.getAge()).get() ;
		System.out.println("The Oldest Student is : "+maxAge.getName());
		
		Student minAge = students.stream().min((s11, s22) -> (int)s11.getAge() - (int) s22.getAge()).get() ;
		System.out.println("The Oldest Student is : "+minAge.getName());
		
		Collections.sort(studentList, (s1, s2) -> s1.getStuId() > s2.getStuId()?1 : -1);
		
		List<Student> studs = studentList.stream().filter(s -> s.getAge() > 18).collect(Collectors.toList()) ;
		studs.forEach(st -> System.out.println("Student Who are above Age 18 id : "+st.getName()));
		System.out.println();
		
		List<Student> st2 = school2.getStudentList() ;
		List<Student> stli = st2.stream().filter(sss -> sss.getAge() > 20).collect(Collectors.toList()) ;
		stli.forEach(stl -> System.out.println("Student Above Age 20 are : " + stl.getName()));
		
//		System.out.println(school);
	}
}
