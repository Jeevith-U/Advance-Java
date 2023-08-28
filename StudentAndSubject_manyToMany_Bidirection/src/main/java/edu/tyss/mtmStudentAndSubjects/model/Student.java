package edu.tyss.mtmStudentAndSubjects.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	private int id;
	private String Name ;
	
	@ManyToMany(mappedBy = "listOfStudents")
	
	private List<Subjects> listOfSubList ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Subjects> getListOfSubList() {
		return listOfSubList;
	}

	public void setListOfSubList(List<Subjects> listOfSubList) {
		this.listOfSubList = listOfSubList;
	}
	
}
