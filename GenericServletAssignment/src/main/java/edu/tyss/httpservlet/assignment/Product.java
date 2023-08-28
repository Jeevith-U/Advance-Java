package edu.tyss.httpservlet.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Product extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		writer.print("<html><body>");
		writer.print("<h3>"+req.getParameter("id")+"</h3>");
		writer.print("<h3>"+req.getParameter("name")+"</h3>");
		writer.print("<h3>"+req.getParameter("price")+"</h3>");
		writer.print("<h3>"+req.getParameter("qua")+"</h3>");
		writer.print("<h3>Total Price : "+Integer.valueOf( req.getParameter("price"))*Integer.valueOf(req.getParameter("qua"))+"</h3>");
		writer.print("</body></html>");
		
		
	}
}
