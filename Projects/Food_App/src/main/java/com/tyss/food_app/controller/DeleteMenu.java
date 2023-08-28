package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.userDaoImplementation.MenuDaoImplementation;

@WebServlet(value = "/deletemenu")
public class DeleteMenu extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuDaoImplementation dao = new MenuDaoImplementation() ;
		
		Integer id = Integer.valueOf(req.getParameter("id")) ;
		
		dao.delete(id) ;
		
		RequestDispatcher disp = req.getRequestDispatcher("menu.jsp") ;
		disp.forward(req, resp);
	}
}
