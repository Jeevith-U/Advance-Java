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

	<h1>Mr. ${staffuser.getName()} is at Service</h1>

	<h2>Food Items</h2>

	<%-- <form:form action="saveOrder" >  modelAttribute="orderlist" --%>

		<table border="2px" cellpadding="10">
			<!--  -->

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Type</th>
				<th>About</th>
				<th>Avalilability</th>
				<th>price</th>
				<th>Quantity</th>
				<th>Add</th>
			</tr>

			<c:forEach var="p" items="${productList}" >
				<tr>
					<td>${p.getId() }</td>
					<td>${p.getName() }</td>
					<td>${p.getType()}</td>
					<td>${p.getAbout()}</td>
					<td>${p.getAvailability()}</td>
					<td>${p.getPrice()}</td>
					<td><input type="number"></td>
					<td><input type="checkbox"></td>
				</tr>
			</c:forEach>
			<button type="submit">Submit</button>
		</table>
		<%--<form:button>Submit</form:button>
	</form:form>--%>
</body>
</html>