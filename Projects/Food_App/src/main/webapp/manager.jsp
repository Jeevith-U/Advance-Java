<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manager Operation</title>

<style>
div {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh
}
</style>
</head>
<body>

	<div>
		<form action="manager" method="post">

			<label> <input type="checkbox" name="option" value="create">
				Create A Menu
			</label><br> <label> <input type="checkbox" name="option"
				value="staff"> Create Staff
				
		    </label><br> <label> <input type="checkbox" name="option"
				value="details"> Get All Branch Details
		    </label><br> <label> <input type="checkbox" name="option"
				value="menu"> Go to Menu
			</label><br> <label> <input type="checkbox" name="option"
				value="delete"> Delete Branch
			</label><br> <td colspan="2px" align="center"> <input type="submit" value = "submit"><!-- </td> -->
               <!-- tdcolspan="2px" align="center"> --><a href="manager.jsp" colspan="2px" align="center"><button>Back</button></a></td>
               

		</form>
	</div>
</body>
</html>