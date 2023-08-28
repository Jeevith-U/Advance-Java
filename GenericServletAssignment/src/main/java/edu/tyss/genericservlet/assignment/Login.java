package edu.tyss.genericservlet.assignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter writer = res.getWriter() ;
		writer.print("<html><body>");
		writer.print("<h3>"+req.getParameter("phonenumber")+"</h3>");
		writer.print("<h3>"+req.getParameter("pass")+"</h3>");
		writer.print("</body></html>");
	}

}
