<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Branch</title>
<style>
table {
	width: 25%;
	margin: auto;
	margin-top: 5px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-around;
}
</style>
</head>
<body>

	<h1 align="center">Welecom Manager You can Add Menu Here</h1>
	<form action="saveMenu" method="post">

		<table>
			<div class="data">
				<tr>
					<td><label for="name">Name</label></td>
					<td><input type="text" id="name" name="name"></td>
				</tr>
				<br> <br>
				<tr>
					<td><label for="about">About</label></td>
					<td><input type="text" id="about" name="about"></td>
				</tr>
				<tr>
					<td><label for="price">Price</label></td>
					<td><input type="number" id="price" name="price"></td>
				</tr>
				<br> <br>
				<tr>
					<td><label for="ava">Availability</label>
					<td><select id="ava" name="ava">
							<option value="AVAILABLE">AVAILABLE</option>
							<option value="NOT_AVAILABLE">NOT_AVAILABLE</option>
					</select></td>
				</tr>
				</tr>
				<br> <br>
				<tr>
					<td><label for="type">Type</label>
					<td><select id="type" name="type">
							<option value="VEG">VEG</option>
							<option value="VEGAN">VEGAN</option>
							<option value="NONVEG">NONVEG</option>
					</select></td>
				</tr>
				<br> <br>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit"></td>
				</tr>
			</div>
		</table>
	</form>
</body>
</html>