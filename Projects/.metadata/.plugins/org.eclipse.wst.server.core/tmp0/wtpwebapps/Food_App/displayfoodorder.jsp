<%@page import="com.tyss.food_app.entity.FoodOder"%>
<%@page
	import="com.tyss.food_app.serviceimplementation.FoodOrderServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="1px">
		<tr>
			<th>Customer Name</th>
			<th>Customer Phone Number</th>
			<th>Orderd Time</th>
			<th>Status</th>
			<th></th>
	</table>
	</tr>
	<%
	int id = Integer.valueOf(request.getParameter("id"));
	FoodOrderServiceImplementation service = new FoodOrderServiceImplementation();
	FoodOder order = service.getFoodOderbyIdService(id);
	%>

	<tr>
		<td><%=order.getCustomerName()%></td>
		<td><%=order.getCustomerPhoneNumber()%></td>
		<td><%=order.getOrderDeliverdTime()%></td>
		<td><%=order.getStatus()%></td>
	</tr>
</body>
</html>