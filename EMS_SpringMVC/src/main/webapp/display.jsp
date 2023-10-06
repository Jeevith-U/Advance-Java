<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table border="2px" solid cellpadding = "12px" >
		<tr>
			<td>EmployeeId</td>
			<td>EmployeeName</td>
			<td>EmployeeEmail</td>
			<td>EmployeePhoneNumber</td>
			<td>EmployeePassword</td>
			<td>EmployeeSalary</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>

		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td>${emp.getId()}</td>
				<td>${emp.getName()}</td>
				<td>${emp.getEmail()}</td>
				<td>${emp.getPhno()}</td>
				<td>${emp.getPassword()}</td>
				<td>${emp.getSalary()}</td>
				<td><a href="edit?id=${emp.getId()}">Edit</a></td>
				<td><a href="delete?id=${emp.getId()}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>