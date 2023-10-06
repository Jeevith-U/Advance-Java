package ModelCollection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("collectionconfiguration.xml") ;
		Student student = (Student)context.getBean("student") ;
		
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getSubjectName());
	}
}
