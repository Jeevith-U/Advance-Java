package PostConstructAndPreDestroy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCyCle {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("PostConstructAndPreDestroy") ;
		
		context.getBean("myperson") ;
	}
}
