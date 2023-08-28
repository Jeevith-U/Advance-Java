package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.food_app.entity.Users;
import com.tyss.food_app.serviceimplementation.UserServiceImplementation;
import com.tyss.food_app.util.Role;

@WebServlet(value = "/login")
public class LogIn extends HttpServlet{
	
	UserServiceImplementation service = new UserServiceImplementation() ;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Users user = service.getUserbyUserNamedService(req.getParameter("name"), req.getParameter("pass")) ;
		
		RequestDispatcher request ;
		
		if( user != null) {
			
			HttpSession session = req.getSession() ;
			session.setAttribute("user", user);
			if (user.getRole().equals(Role.BRANCHMANAGER)) {
				
				System.out.println("Manager");
				RequestDispatcher disp = req.getRequestDispatcher("manager.jsp") ;
				disp.forward(req, resp);
			}
			if (user.getRole().equals(Role.CUSTOMER)) {
				RequestDispatcher disp1 = req.getRequestDispatcher("customer.jsp") ;
				disp1.forward(req, resp);
			}
			if (user.getRole().equals(Role.STAFF)) {
				RequestDispatcher disp2 = req.getRequestDispatcher("staff.jsp") ;
				disp2.forward(req, resp);
			}
		}
		else {
			req.setAttribute("errormessage", "Invalid");
			request = req.getRequestDispatcher("Login.jsp") ;
			request.include(req, resp);
			
		}
		
		
	}
}
