package com.StudentManageSystem.StudentManageSystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.StudentManageSystem.StudentManageSystem.Entity.Student;
import com.StudentManageSystem.StudentManageSystem.Repository.StudentrRepository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentrRepository repo ;
	
	public Student saveStudent(Student student) {
		return repo.save(student) ;
	}
	
	public Student findStudentById(int id) {
		return repo.findById(id) ;
	}
	
	public List<Student> findAllStudent(){
		return repo.findAll() ;
	}
	
	public Student updateStudent(Student student) {
		
		Student upstudent = findStudentById(student.getId()) ;
		
		return null ;
		
	}
	
	public boolean deleteStudentById(int id) {
		 repo.deleteById(id);
		 return true ;
	}
	
	public Student findStudentByEmailAndPassword(String email, String password) {
		
		return repo.findByEmailAndPassword(email, password) ;
	}
	
	public Student findByStudentPhoneNumber(long phono) {
		return repo.findByPhno(phono) ;
	}
	
	public List<Student> findStudentsMarksGreaterThan(int marks){
		return repo.findByMarksGreaterThan(marks) ;
	}
}
