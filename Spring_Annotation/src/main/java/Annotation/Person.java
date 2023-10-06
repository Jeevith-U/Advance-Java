package Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Person {
	
	@Value(value = "PavanGaru")
	private String name ;
	
	private int age ;
	
	private String nationality ;
	
	Person(@Value(value = "22") int age){
		this.age = age ;
	}
	
	/*
	 * Value injection using setter Method
	 */
	
	@Value(value = "India")
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}



	public void running() {
		System.out.println("Run " + name+" Run Run you are "+age+" old Representing "+nationality+"");
	}
}
