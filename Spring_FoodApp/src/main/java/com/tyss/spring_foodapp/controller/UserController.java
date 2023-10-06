package com.tyss.spring_foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tyss.spring_foodapp.dto.Users;
import com.tyss.spring_foodapp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	public UserService service ;
	
	
	@RequestMapping("/signup")
	public ModelAndView landingPage() {
		ModelAndView view = new ModelAndView("signup.jsp") ;
		
		 view.addObject("user", new Users());
		 return view ;
	}
	
	public ModelAndView saveUser(@ModelAttribute Users user) {
		
		ModelAndView view = new ModelAndView("login.jsp") ;
		
		service.saveUser(user);
		
		if (user!= null) {
			
			return view ;
		}
		return view;
		
	}

}
