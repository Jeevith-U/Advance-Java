<%@page import="edu.tyss.userlogin.dto.Users"%>
<%@page import="java.util.List"%>
<%@page import="edu.tyss.userlogin.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
</style>
</head>
<body>

	<table border="2px" solid style="cellpadding = 5px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<%
		
		UserDao dao = new UserDao();

		List<Users> list = dao.getAllUsers();

		for (Users user : list) {
			
		%>

		<tr>
		    
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getPhno()%></td>
			<td><%=user.getPassword()%></td>
			<td><% request.setAttribute("id", user.getId()) ;%><a href="edit.jsp">Edit</a></td>
			<td>Delete</td>
		</tr>

		<%
		}
		%>
	</table>

</body>
</html>