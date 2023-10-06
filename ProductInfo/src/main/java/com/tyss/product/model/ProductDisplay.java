package com.tyss.product.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ProductDisplay extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) 
			throws ServletException, IOException {	
		
		PrintWriter print = response.getWriter() ;
		print.print("<html>");
		print.print("<body>");
		print.print("<h1>"+request.getParameter("id")+"</h1>");
		print.print("<h1>"+request.getParameter("name")+"</h1>");
		print.print("<h1>"+request.getParameter("quan")+"</h1>");
		print.print("<h1>"+request.getParameter("price")+"</h1>");
	}
	
	

}
