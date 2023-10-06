package com.tyss.product.model;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Product extends GenericServlet{

	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {
		
		 System.out.println(request.getParameter("id"));
		 System.out.println(request.getParameter("name"));
		 System.out.println(request.getParameter("quan"));
		 System.out.println(request.getParameter("price"));
	}

}
