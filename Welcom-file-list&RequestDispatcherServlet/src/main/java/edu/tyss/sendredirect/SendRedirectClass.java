package edu.tyss.sendredirect;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/redirect", loadOnStartup = 2)
public class SendRedirectClass extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reqloan = req.getParameter("loan");
		System.out.println(reqloan);
		if(reqloan.equalsIgnoreCase("News"))
			resp.sendRedirect("https://timesofindia.indiatimes.com/");
		if (reqloan.equalsIgnoreCase("twitter"))
			resp.sendRedirect("https://twitter.com/");
		if (reqloan.equalsIgnoreCase("gold"))
			resp.sendRedirect("https://www.oromoney.in/?utm_source=google&utm_medium=search&utm_campaign=goldloan&utm_id=need&gad=1&gclid=Cj0KCQjwoeemBhCfARIsADR2QCuZxdhr8f4g-5kvQvNQglhEB4yctRENNyY6wDTgeODwS2_zgKgnPpYaAkuZEALw_wcB");
		else
			resp.sendRedirect("https://www.google.com/");
	}
}
