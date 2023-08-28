package edu.tyss.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
		String name = req.getParameter("un") ;
		String pass = req.getParameter("pass") ;
		
		req.setAttribute("name", name);
		req.setAttribute("pass", pass);
		
		if (name.equalsIgnoreCase("Jeevith") && pass.equals("jeevith22")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("application") ; // link of next servlet
		    dispatcher.forward(req, resp);
		}
		else
			writer.print("<html><body>");
		writer.print("<h1>Invalid Credentials</h1>");
		writer.print("</body></html>");
		    RequestDispatcher dispatcher = req.getRequestDispatcher("forms.html") ; // include dispatcher 
		    dispatcher.include(req, resp);
	}
}
