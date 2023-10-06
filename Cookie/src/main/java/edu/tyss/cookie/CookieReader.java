package edu.tyss.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/use")
public class CookieReader extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Cookie[] list = req.getCookies() ;
		
		for (Cookie cookie : list) {
			
			if (cookie.getName().equals("Name")) {
				System.out.println(cookie.getValue());
				System.out.println(cookie.getComment());
				System.out.println(cookie.getMaxAge());
				System.out.println(cookie.getDomain());
				System.out.println(cookie.getValue());
			}
		}
	}

}
