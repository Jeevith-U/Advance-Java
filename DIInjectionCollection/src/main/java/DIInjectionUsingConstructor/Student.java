package DIInjectionUsingConstructor;

public class Student {
	
	private String name ;
	
	private Student(String name) {
		super() ;
		this.name = name ;
	}
	
	public void printName() {
		System.out.println("The Name is : "+name);
	}
}
