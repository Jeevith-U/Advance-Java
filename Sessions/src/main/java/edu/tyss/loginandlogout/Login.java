package edu.tyss.loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/login")
public class Login extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter() ;
		writer.print("<html><body>");
		
		String name = req.getParameter("name") ;
		String pass = req.getParameter("pass") ;
		
		if (name.equalsIgnoreCase("Jeevith") && pass.equalsIgnoreCase("pas5wo6d")) {
			
			HttpSession session = req.getSession() ;
			session.setAttribute("name", name);
			RequestDispatcher request = req.getRequestDispatcher("home") ;
			request.forward(req, resp);
			
		}else {
			
			writer.print("<h3>Invalied Password or User Name</h3>");
			
			RequestDispatcher request1 = req.getRequestDispatcher("login.html") ;
			
			request1.include(req, resp) ;
			
		}
		writer.print("</body></html>");
	}
}
