<%@page import="edu.tyss.userlogin.dto.Users"%>
<%@page import="edu.tyss.userlogin.dao.UserDao"%>
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

UserDao dao = new UserDao () ;

int id = (int)request.getAttribute("id");

Users user = dao.findUser(id) ;

String readOnly = "CAN_READ".equals(request.getParameter("id")) ? "readOnly" : "";

%>

<form action="update" method="post">
ID :<input type = "number" name="id" <%=readOnly%>>
Name : <input type = "text" name="name" placeholder="<%= user.getName() %>">
Email<input type = "email" name="email" placeholder="<%= user.getEmail() %>" >
Phone Number<input type = "tel" name="phno" placeholder="<%= user.getEmail() %>" >
Password<input type = "password" name="pass" placeholder="<%= user.getEmail() %>">
<input type="submit">
</form>
</body>
</html>