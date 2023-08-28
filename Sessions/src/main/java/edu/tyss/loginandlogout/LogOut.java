package edu.tyss.loginandlogout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/logout")
public class LogOut extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
		HttpSession session = req.getSession() ;
		session.invalidate();
		
		req.getSession() ;
		writer.print("<html><body>");
		writer.print("<h3>You logged out successfully 🥲🥲</h3>");
		writer.print("</body></html>");
	}

}
