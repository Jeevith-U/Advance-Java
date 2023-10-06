package Person;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMobile {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config2.xml") ;
		MobileDriver mobile = (MobileDriver)context.getBean("mymobile") ;
		
		mobile.use();
		
	}
}
