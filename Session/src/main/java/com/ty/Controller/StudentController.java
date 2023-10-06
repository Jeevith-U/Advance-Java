package com.ty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ty.Entity.Student;

@Controller
@SessionAttributes({"student"})
public class StudentController {
	
	@RequestMapping("/student")
	public ModelAndView setStudent(Student student, ModelAndView mav) {
		mav.setViewName("session.jsp") ;
		student.setId(101) ;
		student.setName("Meera") ;
		student.setAge(22) ;
		mav.addObject("student", student) ;
		return mav ;
	}
	@RequestMapping("/get")
	public ModelAndView get(@SessionAttribute(name = "mystudent") Student student,ModelAndView mav) {
		mav.setViewName("index.jsp");
		System.out.println(student);
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView updateSession(@SessionAttribute(name = "student") Student newStudent,ModelAndView mav ) {
		mav.setViewName("index.jsp") ;
		newStudent.setName("Jeevith") ;
		System.out.println(newStudent);
		return mav ;
	}
}
