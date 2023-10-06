<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="saveeditedfood" method="post" modelAttribute="editfpproduct">
Id : <form:input path="id"  readonly="true"/>
Name : <form:input path="name"/>
Type : <form:input path="type"/>
About : <form:input path="about"/>
Availability : <form:input path="availability"/>
Price : <form:input path="price"/>
<form:button type="submit">Change Food</form:button>
</form:form>

</body>
</html>