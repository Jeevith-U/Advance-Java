package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/staffop")
public class StaffOperation extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("op") ;
		
		if (operation.equals("create")) {
			RequestDispatcher disp = req.getRequestDispatcher("createfoodorder.jsp") ;
			disp.forward(req, resp);
		}
		if (operation.equals("find")) {
			RequestDispatcher disp = req.getRequestDispatcher("findfoodorder.jsp") ;
			disp.forward(req, resp);
		}
		if (operation.equals("update")) {
			RequestDispatcher disp = req.getRequestDispatcher("updatefoodorder.jsp") ;
			disp.forward(req, resp);
		}
		if (operation.equals("get")) {
			RequestDispatcher disp = req.getRequestDispatcher("getfoodorder.jsp") ;
			disp.forward(req, resp);
		}
		if (operation.equals("delete")) {
			RequestDispatcher disp = req.getRequestDispatcher("findfoodordertodelete.jsp.jsp") ;
			disp.forward(req, resp);
		}
	}

}
