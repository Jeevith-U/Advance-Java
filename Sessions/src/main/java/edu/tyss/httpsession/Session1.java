package edu.tyss.httpsession;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/create", loadOnStartup = 1, name = "Balaya" )
public class Session1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession() ;
		
		SessionContent content = new SessionContent() ;
		
		content.sessionId = 22 ;
		content.sessionName = "Session1" ;
		content.sessionType = "Regular" ;

		session.setAttribute("detail", content);
		
		System.out.println("Sesion Created...");
	}
	
	
}
