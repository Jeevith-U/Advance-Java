package edu.tyss.servlet_program.httpservlet.doGet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("First Name : "+req.getParameter("firstName"));
		System.out.println("Last Name : "+req.getParameter("lastName"));
		System.out.println("User Name : "+req.getParameter("username"));
		System.out.println("Password : "+req.getParameter("password"));
		System.out.println(" Address: "+req.getParameter("address"));
		System.out.println("Phone Number : "+req.getParameter("contact"));
		
		PrintWriter writer = resp.getWriter() ;
		writer.print("<html><body>");
		writer.print("<h1> FirstName : "+req.getParameter("firstName")+"<h1>");
		writer.print("<h1> LAstName : "+req.getParameter("lastName")+"<h1>");
		writer.print("<h1> USer Name : "+req.getParameter("username")+"<h1>");
		writer.print("<h1> Password : "+req.getParameter("password")+"<h1>");
		writer.print("<h1> Address : "+req.getParameter("address")+"<h1>");
		writer.print("<h1> Contact : "+req.getParameter("contact")+"<h1>");
		
	}
}
