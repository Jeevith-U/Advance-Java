package DIMapUsingConstructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("DIMapUsingConstructor.xml") ;
		Shop shop = (Shop)context.getBean("myshop") ;
		shop.diplay();
		
	}
}
