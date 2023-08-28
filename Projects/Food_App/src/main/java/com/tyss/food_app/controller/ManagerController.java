package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.serviceimplementation.BranchServiceImplementation;

@WebServlet(value = "/manager")
public class ManagerController extends HttpServlet {
	
	BranchServiceImplementation service = new  BranchServiceImplementation() ;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("option") ;
		
		if (operation.equalsIgnoreCase("create")) {
			RequestDispatcher dispatch1 = req.getRequestDispatcher("branch.jsp") ;
			dispatch1.forward(req, resp);
		}
		if(operation.equalsIgnoreCase("staff")) {
			RequestDispatcher dispatch = req.getRequestDispatcher("SignUp.jsp") ;
			dispatch.forward(req, resp);
		}
		if(operation.equalsIgnoreCase("menu")) {
			RequestDispatcher dispatch = req.getRequestDispatcher("menu.jsp") ;
			dispatch.forward(req, resp);
		}
		
		if(operation.equalsIgnoreCase("details"))
			resp.sendRedirect("details.jsp");
		
		if (operation.equalsIgnoreCase("delete")) {
			resp.sendRedirect("delete.jsp") ;
		}
	}
	
}
