package edu.tyss.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/create")
public class CookieCreator extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("Name", "Jeevith") ;
		cookie.setMaxAge(60*60*24);
		cookie.setComment("For checking purpose");
		cookie.setDomain("www.vich.com");
		cookie.setValue("nish");
		resp.addCookie(cookie);
	}

}
