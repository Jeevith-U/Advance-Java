package com.tyss.food_app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.food_app.entity.FoodOder;
import com.tyss.food_app.entity.Food_Product;
import com.tyss.food_app.entity.Item;
import com.tyss.food_app.userDaoImplementation.FoodOrderImplementation;
import com.tyss.food_app.userDaoImplementation.Food_ProductDaoImplementation;

@WebServlet(value = "/createFood")
public class CreateFoodOrder extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Food_ProductDaoImplementation fpdao = new Food_ProductDaoImplementation() ;
		
		FoodOder order = new FoodOder() ;
		
		FoodOrderImplementation dao = new FoodOrderImplementation() ;
		
		order.setStatus(req.getParameter("status")) ;
		order.setCustomerName(req.getParameter("name")) ;
		order.setCustomerPhoneNumber(Long.valueOf(req.getParameter("phno"))) ;
		
		String[] parameterValues = req.getParameterValues("item") ;
		
		List<Item> itemList = new ArrayList<Item>() ;
		
		double sum = 0 ;
		
		for (String string : parameterValues) {
			
			Food_Product produ = fpdao.findFoodProduct(Integer.valueOf(string)) ;
			
			Item item = new Item() ;
			
			item.setName(produ.getName());
			item.setProductId(produ.getId());
			item.setType(produ.getType());
			item.setQuantity(Integer.valueOf( req.getParameter("quan")));
			item.setPrice(Double.valueOf(produ.getPrice()));
			
			sum += Double.valueOf(produ.getPrice()) ;
			
			itemList.add(item) ;
		}
		
		order.setTotalPrice(sum);
		
		dao.saveFoodOrder(order) ;
		
		RequestDispatcher disp = req.getRequestDispatcher("staff.jsp") ;
		disp.forward(req, resp);
	}
}
