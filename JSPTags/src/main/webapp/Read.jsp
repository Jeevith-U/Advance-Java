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
	String fname = (String) request.getParameter("fname");
	String lname = (String) request.getParameter("lname");
	String email = (String) request.getParameter("email");
	String phone = (String)request.getParameter("tel");
	%>

	<table>
		
		<tr><td><%=fname %></td></tr>
		<tr><h1><td><%=lname %></td></h1></tr>
		<tr><h1><td><%=email %></td></h1></tr>
		<tr><h1><td><%=phone %></td></h1></tr>
		
	</table>
</body>
</html>