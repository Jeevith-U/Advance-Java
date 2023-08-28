package com.tyss.food_app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.userDaoImplementation.FoodOrderImplementation;

@WebServlet(value = "/updatefoodorder")
public class UpdateFoodOrder extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FoodOrderImplementation dao = new FoodOrderImplementation() ;
		
		int id = Integer.valueOf(req.getParameter("id")) ;
		
		FoodOder order = dao.findFoodOrder(id) ;
		
		order.setStatus(req.getParameter("status"));
		
		dao.upadateFoodOrder(order) ;
		
		RequestDispatcher disp = req.getRequestDispatcher("staff.jsp") ;
		disp.forward(req, resp);
	}

}
