<%@page import="java.util.List"%>
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


	<table border="2px" >
		<tr>
			<th>Customer Name</th>
			<th>Customer Phone Number</th>
			<th>Orderd Time</th>
			<th>Status</th>
	</table>
	</tr>

	<%
	FoodOrderServiceImplementation service = new FoodOrderServiceImplementation();
    List<FoodOder> orders = service.getAllFoodOrderService() ;
    for(FoodOder order : orders) {%>

	<tr>
		<td><%=order.getCustomerName()%></td>
		<td><%=order.getCustomerPhoneNumber()%></td>
		<td><%=order.getOrderDeliverdTime()%></td>
		<td><%=order.getStatus()%></td>
	</tr>
	<br>
	<td><a href="staff.jsp"><button>Back</button></a></td>
	<%}%>

</body>
</html>