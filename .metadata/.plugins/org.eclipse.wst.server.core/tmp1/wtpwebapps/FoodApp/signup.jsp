<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>\
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Register Form</h1>

	<form:form action="saveuser" modelAttribute="users">
	
	Name:<form:input path="name" />
		<br>
		Email:<form:input path="email" />
		<br>
		Password:<form:input path="password" />
		<br>
		  <div class="form-group">
                <label>Role</label>
                <input type="radio" name="role" value="BRANCHMANAGER" required> Branch Manager<br>
                <input type="radio" name="role" value="CUSTOMER" required> Customer<br>
                <input type="radio" name="role" value="STAFF" required> Staff<br>
            </div>
	<!-- 	<label>Select User Type:</label>
		<br>
		<input type="radio" name="userType" value="manager" id="manager">
		<label for="manager">Manager</label>
		<br>

		<input type="radio" name="userType" value="staff" id="staff">
		<label for="staff">Staff</label>
		<br>

		<input type="radio" name="userType" value="customer" id="customer">
		<label for="customer">Customer</label>
		<br> -->

		<input type="submit" value="Submit">
	</form:form>

</body>
</html>