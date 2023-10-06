package DIInjectionUsingPropertiesFile;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestA {
	
	public static void main(String[] args) {
		 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("DIInjectionUsingPropertiesFile.xml") ;
	    Object m = (Mobile)context.getBean("mobile") ;
	    
	    System.out.println(m);
	}
}

