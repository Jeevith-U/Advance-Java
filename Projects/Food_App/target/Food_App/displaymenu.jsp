<%@page import="com.tyss.food_app.entity.Food_Product"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.food_app.entity.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="" solid>

		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th>Product Type</th>
			<th>Product Price</th>
			<th>Product Availability</th>

		</tr>

		<% 
           Menu menu = (Menu)session.getAttribute("findmenu") ;
           List<Food_Product> list = menu.getProductList() ;
           for(Food_Product product12 : list) { %>

		<tr>
			<td><%= product12.getId() %></td>
			<td><%= product12.getName() %></td>
			<td><%= product12.getType()%></td>
			<td><%= product12.getPrice()%></td>
			<td><%= product12.getAvailability()%></td>

		</tr>
		<% } %>
		<input type="submit" value="submit">
	</table>

</body>
</html>