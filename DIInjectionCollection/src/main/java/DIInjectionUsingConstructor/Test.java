package DIInjectionUsingConstructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("constructorConfiguration.xml") ;
		
		Student s = (Student)context.getBean("mystudent") ;
		
		s.printName();
	}
}
