package edu.tyss.servletcontext.dto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet1", loadOnStartup = 1 )
public class Servlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();

		ServletContext context = getServletContext();
		
//		ServletContext context2 = req.getServletContext() ;
		
	/*	ServletConfig config = getServletConfig() ;
		ServletContext context3 = config.getServletContext() ;
		
		writer.print("<html><body>");
		writer.print(context.getInitParameter("user <br><br>"));
		writer.print(context.getInitParameter("databaseURL <br><br>"));
		writer.print(context.getInitParameter("password <br><br>"));
		writer.print("</body></html>"); */
		
		LapTop laptop = new LapTop() ;
		
		laptop.setId(101) ;
		laptop.setBrandName("dell") ;
		laptop.setQuantity(2) ;
		laptop.setPrice(6700000) ;
		
		context.setAttribute("laptop", laptop) ;
		
		ServletConfig config = getServletConfig() ;
		
		String pi = config.getInitParameter("pi") ;
		
		writer.print("<html><body>");
		writer.print("<h1>pi<h1>");
		writer.print("</body></html>"); 
		
		
	}

}
