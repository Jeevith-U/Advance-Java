package edu.tyss.loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/home")
public class Home extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		writer.print("<html><body>");
		
		writer.print("<h3>Your are In Home Page</h3>");
		RequestDispatcher request = req.getRequestDispatcher("") ;
		request.
		writer.print("</body></html>");
	}

}
