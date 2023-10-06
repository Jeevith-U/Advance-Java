package com.StudentManageSystem.StudentManageSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.StudentManageSystem.StudentManageSystem.Entity.Student;

public interface StudentrRepository extends JpaRepository<Student,Integer>{
	
	Student findByName(String name) ;
	
	@Query("select s from Student s where s.email = ?1 and s.password = ?2")
	Student findByEmailAndPassword(String email, String passString) ;
	
	@Query("select s from Student s where s.phno = : phone")
	Student findByPhno(long phone) ;
	
	@Query("select s from Student s where s.marks = : marks")
	List<Student> findByMarksGreaterThan(int marks) ;
	
	@Query("select s from Student s where s.id = ?1")
	Student findById(int id) ;

}
