<%@page import="com.tyss.food_app.serviceimplementation.FoodOrderServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int id = Integer.valueOf(request.getParameter("id"));
	FoodOrderServiceImplementation service = new FoodOrderServiceImplementation();
    service.deleteFoodOder(id) ;
    RequestDispatcher disp = request.getRequestDispatcher("staff.jsp") ;
    disp.forward(request, response) ;
	%>

</body>
</html>