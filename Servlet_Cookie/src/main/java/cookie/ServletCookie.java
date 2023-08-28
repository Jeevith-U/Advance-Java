package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class ServletCookie extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookie = new Cookie("User", "Jeevith");
		cookie.setMaxAge(1*24*60*60);
		cookie.setComment("this is test");
		resp.addCookie(cookie);
		
		Cookie cooki2 = new Cookie("password", "pas5wo6d") ;
		resp.addCookie(cooki2);

		System.out.println("cookie created and added to response");
	}
}
