package com.tyss.food_app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.food_app.entity.Branch;
import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.entity.Menu;
import com.tyss.food_app.entity.Users;
import com.tyss.food_app.userDaoImplementation.BranchDaoImplementation;
import com.tyss.food_app.userDaoImplementation.Food_ProductDaoImplementation;
import com.tyss.food_app.userDaoImplementation.MenuDaoImplementation;
import com.tyss.food_app.util.Availability;
import com.tyss.food_app.util.Type;

@WebServlet(value = "/saveMenu")
public class SaveBranch extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MenuDaoImplementation mdao = new MenuDaoImplementation();
		
		Food_ProductDaoImplementation pdao = new Food_ProductDaoImplementation() ;

		Menu menu = new Menu();
		
		Food_Product product = new Food_Product() ;
		
		List<Food_Product> productList = new ArrayList<Food_Product>() ;

		BranchDaoImplementation dao = new BranchDaoImplementation();

		product.setName(req.getParameter("name"));

		product.setAbout(req.getParameter("about"));

		product.setPrice(Double.valueOf(req.getParameter("price")));

		String availability = req.getParameter("ava");
		
		if (availability.equalsIgnoreCase("AVAILABLE")) {
			product.setAvailability(Availability.AVAILABLE);
		}else {
			product.setAvailability(Availability.NOT_AVAILABLE);
		}
		
		String type = req.getParameter("type");
		
		if (type.equalsIgnoreCase("VEG")) {
			product.setType(Type.VEG);
		}
		if (type.equalsIgnoreCase("VEGAN")) {
			product.setType(Type.VEGAN);
		}
		if (type.equalsIgnoreCase("NONVEG")) {
			product.setType(Type.NONVEG);
		}
		
		productList.add(product) ;
		

		HttpSession session = req.getSession();

		Users user = (Users) session.getAttribute("user");
		
		product.setMenu(menu);
		
//		pdao.saveFoodProduct(product) ;
		
		menu.setUsers(user);
		
		menu.setProductList(productList);
		
		session.setAttribute("menu", menu);
		session.setAttribute("product", product);
		mdao.saveMenu(menu);
		resp.sendRedirect("manager.jsp");
		
		
	}

}
