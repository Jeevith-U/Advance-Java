package edu.tyss.core1;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver {
	
	public static void main(String[] args) {
		
		Resource resource = new ClassPathResource("my_config.xml") ;
		
		XmlBeanFactory bean = new XmlBeanFactory(resource) ;
		
		Person per = (Person)bean.getBean("myperson") ;
		
		per.message() ;
	}
}
