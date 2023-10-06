package com.exceptionHandling.ExceptionHandling.StudentController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exceptionHandling.ExceptionHandling.ResponseStructure.ResponseStructure;
import com.exceptionHandling.ExceptionHandling.model.Student;

@RestController
public class StudentClass {

	@PostMapping("/student")
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student){
		
		String stuname = student.getName() ;
		stuname = stuname + " : "+stuname.length() ;
		student.setName(stuname);
		
		ResponseStructure<Student> response = new ResponseStructure<Student>() ;
		response.setStatusCode(200) ;
		response.setMessage("success") ;
		response.setData(student) ;
		
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.OK) ;
	}
}
