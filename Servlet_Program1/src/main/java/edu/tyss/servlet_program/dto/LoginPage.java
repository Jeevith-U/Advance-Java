package edu.tyss.servlet_program.dto;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginPage extends GenericServlet{

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
//		System.out.println("This message is from Login page Servlet"); /* this will print in the console */
		
		PrintWriter writer = res.getWriter() ;
		writer.print("<html><body>");
		writer.print("<h1>This message is from Login page Servlet</h1>");
		writer.print("</body></html>");
	}
	
}
