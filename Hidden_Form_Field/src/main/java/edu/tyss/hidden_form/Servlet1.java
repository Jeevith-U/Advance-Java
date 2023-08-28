package edu.tyss.hidden_form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet1")
public class Servlet1 extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
		String name = req.getParameter("fname") ;
		
		writer.print("<html><body>");
		
		writer.print("<h3>This is from Servlet a</h3>");
		
		writer.print("<form action='servlet2' >") ;
		writer.print("<input type='hidden' name='fname' value ="+req.getParameter("fname")+"><br>") ;
		writer.print("Email :<input type= 'email'  name= 'email'><br>") ;
		writer.print("Phone : <input type= 'tel'  name= 'phone'><br>") ;
		writer.print(" <input type='submit' value='Submit'>") ;
		writer.print("</form>") ;
		
		writer.print("</body></html>");
	}

}
