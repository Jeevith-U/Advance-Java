package edu.tyss.loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/contentData")
public class ContentClass extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getParameter("") ;
		PrintWriter writer = resp.getWriter() ;
		
		writer.print("<html><body>");
		writer.print("<h3>Your Entered diffrent Page Click the following link to redirect</h3>");
		writer.print("<h3><a href = https://mvnrepository.com/>Link</h3>");
		
		writer.print("</body></html>");
	}

}
