<%@page import="edu.ty.implicit_object_request.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Student student =  (Student)request.getAttribute("student") ;%>

<h1>Student Id : <%=student.getSid() %> </h1><br>
<h1>Student Name : <%=student.getSname() %> </h1><br>
<h1>Student Age : <%=student.getSage() %> </h1><br>
<h1>Student PhoneNumber : <%=student.getPhno()  %> </h1><br>
</body>
</html>