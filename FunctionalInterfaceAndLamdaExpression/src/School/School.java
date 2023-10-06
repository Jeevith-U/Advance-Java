package School;

import java.util.List;

public class School {
	
	private int id ;
	private String name ;
	private String address ;
	
	private List<Student> studentList ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		School sch = (School)obj ;
		
		if (this.id == sch.id && this.name == sch.name && this.address == sch.address) {
			return true ;
		}else
			return false ;
	}
	
	@Override
	public int hashCode() {
		
		Integer id1 = id ;
		String name1 = name ;
		String address1 = address ;
		
		return id1.hashCode()+name1.hashCode()+address1.hashCode() ;
	}
	
	public School() {
		
	}
	
	public School(int id, String name, String address, List<Student> studentList) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", studentList=" + studentList + "]";
	}
	
}
