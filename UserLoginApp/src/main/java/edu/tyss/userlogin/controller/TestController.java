package edu.tyss.userlogin.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.tyss.userlogin.config.ConfigurationClass;
import edu.tyss.userlogin.dao.UserDao;
import edu.tyss.userlogin.dto.Users;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TestController {
	
	UserDao dao = new UserDao() ;
	
	@PostMapping("/signup")
	public ModelAndView getData(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView("signup.jsp") ;
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class) ;
		
		String name  = request.getParameter("name") ;
		String email =  request.getParameter("email") ;
		String pass =  request.getParameter("pass") ;
		String phno =  request.getParameter("phone") ;
		
		
		Users user = (Users)context.getBean("users") ;
		user.setEmail(email);
		user.setName(name);
		user.setPassword(pass);
		user.setPhno(phno);
		
		dao.saveUsers(user);
		
		System.out.println(user);
		
		return view;
		
	}
	
	@PostMapping("/update")
	public ModelAndView updateUser(HttpServletRequest request) {
		
		ModelAndView view = new ModelAndView("signup.jsp") ;
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class) ;
		
		Users upUser = (Users)context.getBean("users") ;
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		 
		Users user = dao.findUser(id) ;
		
		user.setName(request.getParameter("name")) ;
		user.setEmail(request.getParameter("email")) ;
		user.setPassword(request.getParameter("pass")) ;
		user.setPhno(request.getParameter("phno")) ;
		
		dao.saveUsers(user) ;
		
		return view;
	}
	
	
}
