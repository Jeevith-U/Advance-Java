package com.tyss.AnnotationInInterface.variable;

import org.springframework.stereotype.Component;

@Component
public class NonVegFood implements Food {

	public void cutting() {
		
		System.out.println("We are cutting Chicken To cook Biriyani😎😎");
	}
	
	
}
