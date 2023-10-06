package DIInjectionUsingConstructor2;

public class Person {
	
	private Mobile mobile ;
	
	public Person(Mobile mobile) {
		this.mobile = mobile ;
	}
	
	public void use() {
		System.out.println("Person is Using");
		mobile.ring();
	}
}
