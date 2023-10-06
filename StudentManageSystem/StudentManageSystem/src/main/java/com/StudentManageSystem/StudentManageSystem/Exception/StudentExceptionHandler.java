package com.StudentManageSystem.StudentManageSystem.Exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.StudentManageSystem.StudentManageSystem.Entity.Student;
import com.StudentManageSystem.StudentManageSystem.ResponseStructure.StudentResponseStructure;

@ControllerAdvice
public class StudentExceptionHandler extends NotFoundException{
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<StudentResponseStructure<String>> notFoundException(NotFoundException notFoundException){
		
		StudentResponseStructure<String> response = new StudentResponseStructure<String>()  ;
		
		response.setStatusCode(200) ;
		response.setMessage("success");
		response.setBody("Dealing with NUll");
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage("message : "+ notFoundException.getMessage());
		response.setBody("Dont deal with null");
		return new ResponseEntity<StudentResponseStructure<String>>(response, HttpStatus.NOT_FOUND) ;
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StudentResponseStructure<String>> notFoundException(NullPointerException nullPointerException){
		
		StudentResponseStructure<String> response = new StudentResponseStructure<String>()  ;
		
		response.setStatusCode(200) ;
		response.setMessage("success");
		response.setBody("Dealing with NUll");
		response.setStatusCode(HttpStatus.BAD_REQUEST.value());
		response.setMessage("message : "+ nullPointerException.getMessage());
		response.setBody("Dont deal with null");
		return new ResponseEntity<StudentResponseStructure<String>>(response, HttpStatus.BAD_REQUEST) ;
	}
}
