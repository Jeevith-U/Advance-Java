<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
table{
/* border: 2px solid;
border-radius: 5px ; */
width: 25%;
margin: auto;
margin-top: 5px;
display: flex; 
flex-direction: column;
align-items: center;
justify-content: space-around;
/* padding-top: -200px ; */
}

tr{
/* margin-top: -250px ; */
}
.data{
    margin-top: 5px;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="Read.jsp" method="get" border = "" id = "table">

		<table>
            <div class="data">
			<tr>
				<td><label for="fname">First Name</label></td>
				<td><input type="text" id="fname" name="fname"></td>
			</tr>
			<br>
			<br>
			<tr>
				<td><label for="lname">Last Name</label></td>
				<td><input type="text" id="lname" name="lname"></td>
			</tr>
			<br>
			<br>
			<tr>
				<td><label for="email">Email</label></td>
				<td><input type="email" id="email" name="email"></td>
			</tr>
			<tr>
				<td><label for="tel">Phone Number</label></td>
				<td><input type="tel" id="tel" name="tel"></td>
			</tr>
			<br>
			<br>
			<tr>
				<td style="margin-left: 50px;"><input type="submit" value="Submit"></td>
			</tr>
        </div>
		</table>
	</form>
</body>
</html>