package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.userDaoImplementation.BranchDaoImplementation;

@WebServlet(value = "/delete")
public class DeleteBranch extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BranchDaoImplementation dao = new BranchDaoImplementation() ;
		
		int id = Integer.valueOf(req.getParameter("number")) ;
		
		dao.deleteBranch(id) ;
		
		RequestDispatcher disp = req.getRequestDispatcher("manager.jsp") ;
		disp.forward(req, resp);
	}
}
