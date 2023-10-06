package Model;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/use")
public class ProductService2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext context = getServletContext();
		Product prod = (Product) context.getAttribute("product");

		System.out.println(prod);

		ServletContext context2 = getServletContext();
		String param = context2.getInitParameter("url") ;
		String url = (String) context2.getAttribute("url");

		System.out.println("Url from Service 2 : " + context2.getInitParameter("url"));
	}

}
