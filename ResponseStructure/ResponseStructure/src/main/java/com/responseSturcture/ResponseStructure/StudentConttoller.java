package com.responseSturcture.ResponseStructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentConttoller {
	
	@PostMapping("/student")
	public ResponseStructure<Student> saveStudent(@RequestBody Student student){
		
		ResponseStructure<Student> response = new ResponseStructure<Student>() ;
		
		response.setStatusCode(200) ;
		response.setMessage("success") ;
		response.setData(student) ;
		return response ;
	}
	
	@GetMapping("/student/{rollno}")
	public ResponseEntity<ResponseStructure<Student>> getStudentBuRollNo(@PathVariable int rollno){
		
		ResponseStructure<Student> response = new ResponseStructure<Student>() ;
				
            if (rollno == 1) {
			
			Student student = new Student() ;
			student.setRollno(1) ;
			student.setName("Anvit") ;
			student.setHeight(6);
			
			response.setStatusCode(200) ;
			response.setMessage("success") ;
			response.setData(student) ;
			return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.OK) ;
		}
		
		response.setStatusCode(404) ;
		response.setMessage("nkn yake yakee data illa") ;
		response.setData(null) ;
		return new ResponseEntity<ResponseStructure<Student>>(response,HttpStatus.NOT_FOUND);
		
		
	}
	
	
	
//	@GetMapping("/student/{rollno}")
	/*
	 * @@RequestParam int id is used when tou send the data using query http://localhost:8080/save?rollno=2
	 */
	/*	public ResponseStructure<Student> getStudentById(@PathVariable int rollno){
		
		ResponseStructure<Student> response = new ResponseStructure<Student>() ;
		
		if (rollno == 1) {
			
			Student student = new Student() ;
			student.setRollno(1) ;
			student.setName("Anvit") ;
			student.setHeight(6);
			
			response.setStatusCode(200) ;
			response.setMessage("success") ;
			response.setData(student) ;
			return response ;
		}
		
		response.setStatusCode(404) ;
		response.setMessage("nkn yake yakee data illa") ;
		response.setData(null) ;
		return response;*/
}
