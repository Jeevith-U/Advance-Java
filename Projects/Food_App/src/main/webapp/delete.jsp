<%@page import="java.util.Scanner"%>
<%@page import="com.tyss.food_app.userDaoImplementation.BranchDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="delete" method="post">
<td> Enter the Branch Id  <input type="number" name ="number"></td>
<td colspan="2px" align="center"> <input type="submit" value = "submit"><!-- </td> -->
               <!-- tdcolspan="2px" align="center"> --><a href="manager.jsp" colspan="2px" align="center"><button>Back</button></a></td>
               

</form>
</body>
</html>