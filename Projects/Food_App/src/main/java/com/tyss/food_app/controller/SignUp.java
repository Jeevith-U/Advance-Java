package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.userDaoImplementation.UserDaoImplementation;
import com.tyss.food_app.util.Role;

@WebServlet(value = "/signup")
public class SignUp extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDaoImplementation dao = new UserDaoImplementation() ;
		
		Users user = new Users() ;
		
		user.setName(req.getParameter("name")) ;
		user.setEmail(req.getParameter("email")) ;
		user.setPassword(req.getParameter("pass")) ;
		String role = req.getParameter("role") ;
		System.out.println(role);
		if (role.equals("BRANCHMANAGER")) {
			user.setRole(Role.BRANCHMANAGER) ;
		}
		if (role.equals("CUSTOMER")) {
			user.setRole(Role.CUSTOMER) ;
		}
		if (role.equals("STAFF")) {
			user.setRole(Role.STAFF) ;
		}
		
		dao.saveUser(user) ;
		
		RequestDispatcher disp = req.getRequestDispatcher("index.jsp") ;
		disp.forward(req, resp);
		
	}

}
