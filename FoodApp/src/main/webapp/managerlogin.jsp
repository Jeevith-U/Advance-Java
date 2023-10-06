<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Manager Login Page</h1>
<h3>${msg }</h3>

<form action="loginmanager">
	Email : <input type="email" name="email">
	Password : <input type="password" name="password">
	<button type="submit">Login</button>
</form>


<%-- <form:form action="loginmanager" modelAttribute="managerlog">
Name : <form:input path="email"/> <br>
Password : <form:input path="password"/><br>
<form:button>LOGIN</form:button>
</form:form> --%>

</body>
</html>