package DIInjectionUsingConstructor2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	
	 public static void main(String[] args) {
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("constructorConfiguration2.xml") ;
		 
		 Person person = (Person)context.getBean("myperson") ;
		 
		 person.use();
	}
}
