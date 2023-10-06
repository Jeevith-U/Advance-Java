package com.SpringWithDB.SpringWithDB.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringWithDB.SpringWithDB.model.Student;

@RestController
public class TestController {

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_XML_VALUE)
	public Student getStudent() {

		Student student = new Student();
		student.setName("Jeevith");
		student.setHeight(5.11);
		return student;
	}

	@PostMapping(value = "/test", consumes = MediaType.APPLICATION_XML_VALUE)
	public String readObject(@RequestBody Student student) {
		return "student name is " + student.getName();
	}

	@PostMapping(value = "/insertAndfetch", consumes = MediaType.APPLICATION_XML_VALUE,
			produces = MediaType.APPLICATION_XML_VALUE )
	public Student insertAndFetchStudent(@RequestBody Student student) {
		
		return student ;
	}
	@PostMapping(value = "/insertAndfetchboth", consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE },
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE } )
	public Student insertAndFetchStudentBoth(@RequestBody Student student) {
		
		return student ;
	}
}
