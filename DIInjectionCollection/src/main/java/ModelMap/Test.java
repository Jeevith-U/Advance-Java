package ModelMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("mapconfiguration.xml") ;
		
		Shop shop = (Shop)context.getBean("myshop") ;
		System.out.println(shop.getName());
		System.out.println(shop.getItems());
	}
}
