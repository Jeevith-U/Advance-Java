package Person;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("config.xml") ;
		Person person = (Person)context.getBean("person") ;
		System.out.println(person.getName());
		System.out.println(person.getAge());
		System.out.println(person.getColor());
	}
}
