<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SignUp</title>

<style>
table {
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

tr {
	/* margin-top: -250px ; */
	
}

.data {
	margin-top: 5px;
}
</style>
</head>
<body>

	<%
response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate") ;

%>

	<div align=" center">

		<h1>Welecom To Food App</h1>

		<form action="signup" method="post" border="" id="table">

			<table>
				<div class="data">
					<!--  <tr>
                    <td><label for="id">Id</label></td>
                    <td><input type="text" id="id" name="id"></td>
                </tr>
                <br>
                <br> -->
					<tr>
						<td><label for="name">Name</label></td>
						<td><input type="text" id="name" name="name"></td>
					</tr>
					<br> <br>
					<tr>
						<td><label for="email">Email</label></td>
						<td><input type="email" id="email" name="email"></td>
					</tr>
					<tr>
						<td><label for="pass">Password</label></td>
						<td><input type="password" id="pass" name="pass"></td>
					</tr>
					<br> <br>
					<tr>
						<td><label for="role">Role</label>
						<td><select id="role" name="role">
								<option value="BRANCHMANAGER">Branch Manager</option>
								<option value="CUSTOMER">Customer</option>
								<option value="STAFF">STAFF</option>
						</select></td>
					</tr>
					</tr>
					<br> <br>
					<tr>
						<td colspan="2" align="center""><input type="submit"
							value="Submit"></td>
					</tr>
				</div>
			</table>
		</form>
	</div>

</body>
</html>