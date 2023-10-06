package Driver;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.tyss.core2.j2eecontainer.car.model.Car;
import edu.tyss.core2.j2eecontainer.person.model.Person;
import edu.tyss.core2.model.Phone;

public class MultipleBeanDriver {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml") ;
		
		Phone phone = (Phone)context.getBean("myphone") ;
		Car car = (Car)context.getBean("mycar") ;
		Person person = (Person)context.getBean("person") ;
		
		person.person() ;
		car.driving();
		phone.photo();
	}
}
