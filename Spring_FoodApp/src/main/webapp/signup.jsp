<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="saveUser" method="post" modelAttribute="user">

        Name:<form:input path="userName" />
		<br>
		Email:<form:input path="userEmail" />
		<br>
		PhoneNumber:<form:input path="userPhoneNumber" />
		<br>
		Salary:<form:input path="userSalary" />
		<br>
		Password:<form:input path="userPassword" />

		<label>Select User Type:</label>
		<br>

		<input type="radio" name="userType" value="manager" id="manager">
		<label for="manager">Manager</label>
		<br>

		<input type="radio" name="userType" value="staff" id="staff">
		<label for="staff">Staff</label>
		<br>

		<input type="radio" name="userType" value="customer" id="customer">
		<label for="customer">Customer</label>
		<br>

		<input type="submit" value="Submit">

	</form:form>

</body>
</html>