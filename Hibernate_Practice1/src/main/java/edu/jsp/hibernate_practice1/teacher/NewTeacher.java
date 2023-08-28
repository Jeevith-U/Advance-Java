package edu.jsp.hibernate_practice1.teacher;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewTeacher implements Serializable{
	
	@Id
	private int teacherId ;
	private String teacherName ;
	private String teacherSubject ;
	private String email ;
	
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
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}

	public NewTeacher(){
		
	}

	@Override
	public String toString() {
		return "NewTeacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSubject="
				+ teacherSubject + ", email=" + email + "]";
	}
	
	
}

