package edu.tyss.servletcontext.dto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet2")
public class Servlet2 extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
		ServletContext context = getServletContext() ;
		System.out.println(context.getInitParameter("user"));
		System.out.println(context.getInitParameter("databaseURL"));
		System.out.println(context.getInitParameter("password"));
		
		 LapTop laptop = (LapTop)context.getAttribute("laptop") ;
		 
		 writer.print("<html><body>");
			writer.print(laptop.getId() +"<br><br>");
			writer.print(laptop.getBrandName()+" <br><br>");
			writer.print(laptop.getQuantity()+"<br><br>");
			writer.print(laptop.getPrice()+"<br><br>");
			writer.print("</body></html>");
	}
}
