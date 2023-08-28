package edu.ty.implicit_object_request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/send")
public class SenderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Student student = new Student() ;
		
		student.sid = 202 ;
		student.sname = "Meera" ;
		student.sage = 21;
		student.phno = 987376331 ;
		
		req.setAttribute("student", student);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("displaystudent.jsp") ;
		dispatcher.forward(req, resp);
	}
}
