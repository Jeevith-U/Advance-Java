package edu.tyss.navigation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/page-a")
public class PageA extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
		writer.print("<head><body>") ;
		writer.print("This is from class Page a <br> ");
		writer.print(req.getParameter("id")) ;
		writer.print("</body></head>") ;
	}
}
