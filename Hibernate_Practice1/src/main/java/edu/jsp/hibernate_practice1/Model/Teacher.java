package edu.jsp.hibernate_practice1.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Teacher implements Serializable{
	
	@Id
	private int teacherId ;
	private String teacherName ;
	private String teacherSubject ;
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSubject() {
		return teacherSubject;
	}

	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public Teacher(){
		
	}
	
}
