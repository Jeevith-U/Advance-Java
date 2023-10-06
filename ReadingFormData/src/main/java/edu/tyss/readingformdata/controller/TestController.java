package edu.tyss.readingformdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	@PostMapping("/save")
	public ModelAndView getData(HttpServletRequest request) {
		
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String age = request.getParameter("age") ;
		String gender = request.getParameter("gender") ;
		
		ModelAndView view = new ModelAndView("view.jsp") ;
		
		view.addObject("name", name) ;
		view.addObject("email", email) ;
		view.addObject("age", age) ;
		view.addObject("gender", gender) ;
		
		System.out.println(name);
		
		return view ;
	}
}
