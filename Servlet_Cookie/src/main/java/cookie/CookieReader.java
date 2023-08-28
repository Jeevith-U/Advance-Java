package cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/cookiereader")
public class CookieReader extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter() ;
		
	    Cookie[] list = req.getCookies() ;
	    
	    writer.print("<html><body>");
		for (Cookie cookie : list) {
			
			if (cookie.getName().equalsIgnoreCase("password")) {
				writer.print("<h3>"+cookie.getName()+"</h3>");
				writer.print("<h3>"+cookie.getValue()+"</h3>");
				writer.print("<h3>"+cookie.getComment()+"</h3>");
				writer.print("<h3>"+cookie.getDomain()+"</h3>");
				writer.print("<h3>"+cookie.getValue()+"</h3>");
				System.out.println();
			}
			
			writer.print("<h3>"+cookie.getName()+"</h3>");
			writer.print("<h3>"+cookie.getValue()+"</h3>");
			writer.print("<h3>"+cookie.getComment()+"</h3>");
			writer.print("<h3>"+cookie.getDomain()+"</h3>");
			writer.print("<h3>"+cookie.getValue()+"</h3>");
			System.out.println();
		}
		writer.print("</body></html>");
	}
}
