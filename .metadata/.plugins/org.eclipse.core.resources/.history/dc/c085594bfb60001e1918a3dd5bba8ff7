<%@page import="java.nio.file.attribute.UserPrincipalLookupService"%>
<%@page import="com.tyss.springfoodapp.service.UserService"%>
<%@page import="com.tyss.food_application.Model.Users"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.springfoodapp.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>WELCOME Mr.${user.getName()} To BRANCHMANAGER PAGE</h1>
	<h2>${msg}</h2>
	<a href="createstaff"><button>CRATE STAFF</button></a>
	<a href="createfoodproduct"><button>CRATE FOOD PRODUCT</button></a>

	<table border="2px" cellpadding="10">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Role</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="us" items="${userlist}">
			<tr>
				<td>${us.getId()}</td>
				<td>${us.getName()}</td>
				<td>${us.getEmail()}</td>
				<td>${us.getPassword()}</td>
				<td>${us.getRole()}</td>
				<td><a href="editstaffdetails?id=${us.getId()}"><button>Update</button></a>
				</td>
				<td><a href="deletestaff?id=${us.getId()}"><button>Delete</button>
				</a></td>

			</tr>

		</c:forEach>
	</table>
	<br>
	<br>
	<br>

	<table border="2px" cellpadding="10">
		<!--  -->

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Type</th>
			<th>About</th>
			<th>Avalilability</th>
			<th>price</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="p" items="${prodlist}">
			<tr>
				<td>${p.getId() }</td>
				<td>${p.getName() }</td>
				<td>${p.getType()}</td>
				<td>${p.getAbout()}</td>
				<td>${p.getAvailability()}</td>
				<td>${p.getPrice()}</td>
				<td><a href="editfoodproduct?id=${p.getId()}"><button>Edit</button></a></td>
				<td><a href="deleteFoodProduct?id=${p.getId()}"><button>Delete</button></a></td>
			</tr>
		</c:forEach>

	</table>



</body>
</html>