package edu.tyss.product.objinjectionusingsetter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductDriver {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class) ;
		Product pro = (Product)context.getBean("product") ;
		pro.display();
	}
}
