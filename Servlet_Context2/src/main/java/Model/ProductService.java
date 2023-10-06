package Model;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/createProduct")
public class ProductService extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();

		Product product = new Product(101, "HeadPhones", 4, 12000);
		context.setAttribute("product", product);
		
		ServletContext context2 = getServletContext() ;
		String url = (String)context2.getAttribute("url") ;
		
		System.out.println("Url from Service 1 : "+context2.getInitParameter("url"));
	}

}
