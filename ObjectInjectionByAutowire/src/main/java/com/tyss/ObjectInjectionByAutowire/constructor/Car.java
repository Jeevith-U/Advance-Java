package com.tyss.ObjectInjectionByAutowire.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	Engine engine ;
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine ;
	}
	
	public void display() {
		System.out.println("Car cc : "+engine.cc);
		System.out.println("Car Engine Id : "+engine.engineId);
		System.out.println("Car Brand : "+engine.brand);
		System.out.println("Car price : "+engine.price);
	}
}
