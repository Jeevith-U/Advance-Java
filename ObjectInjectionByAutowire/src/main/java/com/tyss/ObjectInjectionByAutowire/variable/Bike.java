package com.tyss.ObjectInjectionByAutowire.variable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike {
	
	@Autowired
	Engine engine ;
	
	public void display() {
		System.out.println("Bike cc : "+engine.cc);
		System.out.println("Bike Engine Id : "+engine.engineId);
		System.out.println("Bike Brand : "+engine.brand);
		System.out.println("Bike price : "+engine.price);
	}
}
