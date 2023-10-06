package DICollectionListUsingConstructor;

import java.util.List;

public class Student {
	
	private String name ;
	private List<String> subjectName ;
	
	public Student(String name, List<String> subjectName) {
		super();
		this.name = name;
		this.subjectName = subjectName;
	}
	
	public void display() {
		
		System.out.println("The Name Is "+name);
		System.out.println("-------Subject-------");
		for(String subject : subjectName) {
			System.out.println(subject);
		}
	}
	
}
