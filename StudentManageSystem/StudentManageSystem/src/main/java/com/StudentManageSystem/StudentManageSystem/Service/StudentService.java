package com.StudentManageSystem.StudentManageSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentManageSystem.StudentManageSystem.Dao.StudentDao;
import com.StudentManageSystem.StudentManageSystem.Entity.Student;
import com.StudentManageSystem.StudentManageSystem.ResponseStructure.StudentResponseStructure;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao ;
	
	public ResponseEntity<StudentResponseStructure<Student>> saveStudent(Student student){
		
		StudentResponseStructure<Student> response = new StudentResponseStructure<Student>() ;
		response.setStatusCode(200);
		response.setMessage("Success");
		response.setBody(student);
		dao.saveStudent(student) ;
		return new ResponseEntity<StudentResponseStructure<Student>>(response, HttpStatus.OK) ;
	}
	
	public ResponseEntity<StudentResponseStructure<Student>> findStudentById(int id) {
		
		Student student = dao.findStudentById(id) ;
		if(student != null) {
		StudentResponseStructure<Student> response = new StudentResponseStructure<Student>() ;
		response.setStatusCode(200);
		response.setMessage("Success");
		response.setBody(student);
		dao.findStudentById(id) ;
		return new ResponseEntity<StudentResponseStructure<Student>>(response, HttpStatus.OK) ;
		}else {
			StudentResponseStructure<Student> response1 = new StudentResponseStructure<Student>() ;
			response1.setMessage("Student not present With The Id : "+id);
			response1.setStatusCode((HttpStatus.NO_CONTENT.value()) );;
			response1.setBody(null);
			return new ResponseEntity<StudentResponseStructure<Student>>(response1, HttpStatus.NO_CONTENT) ;
		}
		
	}
	
	public ResponseEntity<StudentResponseStructure<Student>> findStudentByPhnoeNymber(long phno) {
		
		if (dao.findByStudentPhoneNumber(phno) != null) {
			StudentResponseStructure<Student> response = new StudentResponseStructure<Student>() ;
			response.setStatusCode(200);
			response.setMessage("success");
			response.setBody(dao.findByStudentPhoneNumber(phno));
			dao.findByStudentPhoneNumber(phno) ;
			return new ResponseEntity<StudentResponseStructure<Student>>(response, HttpStatus.OK);
		}
		else {
			StudentResponseStructure<Student> response1 = new StudentResponseStructure<Student>() ;
			response1.setMessage("Student not present With The Phone Number : "+phno);
			response1.setStatusCode((HttpStatus.NO_CONTENT.value()) );;
			response1.setBody(null);
			return new ResponseEntity<StudentResponseStructure<Student>>(response1, HttpStatus.NO_CONTENT) ;
		}
	}
	
	public List<Student> findAllStudent() {
		return dao.findAllStudent() ;
	}
	
	public Student findByEmailAndPassword(String email, String password) {
		return dao.findStudentByEmailAndPassword(email, password) ;
	}
	
	public boolean deleteStudentById(int id) {
		
		  Student student = dao.findStudentById(id) ;
		
		if (student != null) {
			dao.deleteStudentById(id) ;
			return true ;
		}
		return false ;
	}
	
	public Student updateStudent(Student student) {
		return dao.updateStudent(student) ;
	}
}
