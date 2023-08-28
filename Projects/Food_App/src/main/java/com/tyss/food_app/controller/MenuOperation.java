package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/menuoperation")
public class MenuOperation extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String operation = req.getParameter("option") ;
		if (operation.equals("find")) {
			RequestDispatcher disp = req.getRequestDispatcher("findmenu.jsp");
			disp.forward(req, resp);
		}
/*		if (operation.equals("update")) {
			RequestDispatcher disp1 = req.getRequestDispatcher("updatemenu.jsp");
			disp1.forward(req, resp);
		}*/
		if (operation.equals("details")) {
			RequestDispatcher disp2 = req.getRequestDispatcher("menudetails.jsp");
			disp2.forward(req, resp);
		}
		if (operation.equals("delete")) {
			RequestDispatcher disp3 = req.getRequestDispatcher("deletemenu.jsp");
			disp3.forward(req, resp);
		}
	}
}
