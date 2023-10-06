<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="save" method="post">
	Name :
	<input type="text" name="name"> Email :
	<input type="email" name="email"> Age :
	<input type="number" name="age"> Gender : Male
	<input type="radio" name="gender" value="male"> Female
	<input type="radio" name="gender" value="female">
	<input type="submit" value="submit">
	
	</form>
</body>
</html>