package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.userDaoImplementation.MenuDaoImplementation;

@WebServlet(value = "/findmenu")
public class FindMenu extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuDaoImplementation dao = new MenuDaoImplementation() ;
		Menu menu = dao.findMenu(Integer.valueOf(req.getParameter("id")));
		
		HttpSession session = req.getSession() ;
		session.setAttribute("findmenu", menu);
		
		RequestDispatcher disp = req.getRequestDispatcher("displaymenu.jsp") ;
		
		disp.forward(req, resp);
	}

}
