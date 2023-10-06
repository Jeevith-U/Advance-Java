<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FoodproductCreation</title>
</head>
<body>

<form:form action="saveFoodProduct" modelAttribute="createFoodProduct">
Name : <form:input path="name"/><br>
Type : <form:radiobutton path="type" value="VEG"  label="VEG"/><br>
<form:radiobutton path="type" value="NONVEG" label="NONVEG"/><br>
<form:radiobutton path="type" value="VEGAN" label="VEGAN"/> <br>
Availability : 
<form:radiobutton path="availability" value="NOT_AVAILABLE"  label="NOT_AVAILABLE"/><br>
<form:radiobutton path="availability" value="AVAILABLE"  label="AVAILABLE"/><br>
About<form:input path="about"/><br>
Price<form:input path="price"/><br>
<button type="submit">Create FoodProduct</button>
</form:form>

</body>
</html>