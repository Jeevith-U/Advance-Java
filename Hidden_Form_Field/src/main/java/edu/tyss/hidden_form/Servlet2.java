package edu.tyss.hidden_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	PrintWriter writer = resp.getWriter() ;
	
	writer.print("<html><body>");
	
	writer.print("<h3>This is from Servlet a</h3>");
	
	String name = req.getParameter("fname") ;
	
	writer.print("<h3>"+req.getParameter("fname")+"</h3>");
	writer.print("<h3>"+req.getParameter("email")+"</h3>");
	writer.print("<h3>"+req.getParameter("phone")+"</h3>");
	writer.print("</body></html>");
	
	}
}
