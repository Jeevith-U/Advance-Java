package School;

public class Student {
	
	private int stuId ;
	private String name ;
	private int age ;
	private String standard ;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
	public Student(int stuId, String name, int age, String standard) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.age = age;
		this.standard = standard;
	}
	
	
	@Override
	public int hashCode() {
		
		Integer id1 = stuId ;
		
		return id1.hashCode()+name.hashCode()+standard.hashCode() ;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		
		Student stu = (Student)obj ;
		
		if (this.hashCode() == stu.hashCode()) {
			
		
//		if (this.stuId == stu.stuId && this.name == stu.name && this.age == stu.age && 
//				this.standard == stu.standard) {
			return true ;
		}
			else
				return false ;
	}
	
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + ", age=" + age + ", standard=" + standard + "]";
	}
	
	
}
