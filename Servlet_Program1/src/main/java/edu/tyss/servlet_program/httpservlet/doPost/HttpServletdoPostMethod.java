package edu.tyss.servlet_program.httpservlet.doPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletdoPostMethod extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		writer.print("<html><body>");
		writer.print("<h3> FirstName : "+req.getParameter("firstName")+"<h3>");
		writer.print("<h3> LAstName : "+req.getParameter("lastName")+"<h3>");
		writer.print("<h3> USer Name : "+req.getParameter("username")+"<h3>");
		writer.print("<h3> Password : "+req.getParameter("password")+"<h3>");
		writer.print("<h3> Address : "+req.getParameter("address")+"<h3>");
		writer.print("<h3> Contact : "+req.getParameter("contact")+"<h3>");
		
	}
}
