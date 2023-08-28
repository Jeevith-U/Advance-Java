package edu.tyss.httpsession;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/readSession")
public class Session2 extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession read = req.getSession() ;
		SessionContent content = (SessionContent)read.getAttribute("detail");
		   System.out.println(content.sessionId);
		   System.out.println(content.sessionName);
		   System.out.println(content.sessionType);
	}

}
