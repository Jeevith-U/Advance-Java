<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<!--<%
	String msg = (String) request.getAttribute("errormessage");
	if (msg != null) {
		if (msg.equalsIgnoreCase("Invalid")) {
	%>
	<%="<h1>Invalid User Name Or password Please Check it</h1>"%>

	<%
	}
	}
	%> -->
	
<body>

	
	<form action="login" method="post">
		<table>

			<tr>
				<td><label for="name">Name</label></td>
				<td><input type="text" id="name" name="name"></td>
				<br>
				<br>

			</tr>
			<tr>
				<td><label for="pass">Password</label></td>
				<td><input type="password" id="pass" name="pass"></td>
			</tr>
			<br>
			<br>
			<tr>
				<td colspan="2" align="center"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>