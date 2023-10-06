package Driver;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.tyss.car.model.Car;
import edu.tyss.core2.model.Phone;
import edu.tyss.person.model.Person;

public class DriverClass {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext appcon = new ClassPathXmlApplicationContext("config1.xml") ;
		ConfigurableApplicationContext appcon2 = new ClassPathXmlApplicationContext("config2.xml") ;
		
		Car car = (Car)appcon2.getBean("car") ;
		
		Phone phone = (Phone)appcon.getBean("myphone") ;
		
		Person person = (Person)appcon.getBean("person") ;
		
		car.driving();
		phone.photo();
		person.person();
		
		
	}
}
