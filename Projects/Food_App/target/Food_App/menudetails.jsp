<%@page import="com.tyss.food_app.serviceimplementation.MenuServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.food_app.entity.Food_Product"%>
<%@page import="com.tyss.food_app.entity.Menu"%>
<%@page import="com.tyss.food_app.userDaoImplementation.MenuDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2px">
<tr>
<th>Menu ID</th>
<th>User Name</th>
</tr>
<%/*  int id = Integer.valueOf(request.getParameter("id")) ; */
MenuServiceImplementation service = new MenuServiceImplementation() ;
List<Menu> list = service.getAllMenuervice() ;
  for(Menu menu : list) {%>
  
  <tr>
  <td> <%= menu.getId() %></td>
  <td> <%= menu.getUsers().getName() %></td>
  </tr>
  
  <%}%>
</table>
</body>
</html>