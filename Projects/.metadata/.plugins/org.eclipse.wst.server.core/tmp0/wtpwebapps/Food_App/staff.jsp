<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Staff</title>
<style>
form {
	margin: auto;
	margin-top: 250px;
}
</style>
</head>
<body>
	<form action="staffop" method="post" align="center">

		<input type="radio" name="op" value="create"> Create Food Order 
		<br> <input type="radio" name="op" value="find"> Find Food Order 
		<br> <input type="radio" name="op" value="update">Update Food Order 
		<br> <input type="radio" name="op" value="get">Get All Food Order 
		<br> <input type="radio" name="op" value="delete">Delete Food Order 
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>