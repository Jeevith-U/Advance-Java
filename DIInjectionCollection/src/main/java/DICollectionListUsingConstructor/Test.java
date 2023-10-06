package DICollectionListUsingConstructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("DICollectionUsingConstructor.xml") ;
		
		Student stu = (Student)context.getBean("mystudent") ;
		stu.display() ;
	}
}
