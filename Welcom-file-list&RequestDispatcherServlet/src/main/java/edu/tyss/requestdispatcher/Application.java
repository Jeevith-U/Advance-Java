package edu.tyss.requestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Application extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = (String) req.getAttribute("name");
		String pass = (String) req.getAttribute("pass");

		PrintWriter writer = resp.getWriter();

		writer.print("<html><body>");
		writer.print("<h1>" + name + " Congrats you Enterd Application</h1>");
		writer.print("</body></html>");
	}
}
