<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action ="saveEditStaffDetails" modelAttribute="editstaffdetails">
Id : <form:input path="id" readonly="true"/> 
Name : <form:input path="name"/>
Name : <form:input path="email"/>
Name : <form:input path="password"/>
Name : <form:input path="role" readonly="true"/>
<form:button type = "submit">Change Details</form:button>
</form:form>

</body>
</html>