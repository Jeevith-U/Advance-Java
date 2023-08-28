package edu.tyss.servlet_program.dto;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FormReader extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("First Name : "+req.getParameter("firstname"));
		System.out.println("Last Name : "+req.getParameter("lastname"));
		System.out.println("Email : "+req.getParameter("email"));
		System.out.println("Phone Number : "+req.getParameter("phno"));
		
	}

}
