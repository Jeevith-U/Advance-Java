<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="saveemployee" modelAttribute="employee">
Name : <form:input path="name"/>
<br>
Email : <form:input path="email"/>
<br>
PhoneNumber : <form:input path="phno"/>
<br>
Password : <form:input path="password"/>
<br>
Salary : <form:input path="salary"/>
<br>
<form:button>Register</form:button>
</form:form>
</body>
</html>