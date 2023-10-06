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
Type : <%-- <form:radiobuttons path="type" itemValue="VEG"  itemLabel="VEG"/>
<form:radiobuttons path="type" itemValue="NONVEG" itemLabel="NONVEG"/>
<form:radiobuttons path="type" itemValue="VEGAN" itemLabel="VEGAN"/> --%>
Availability : 
<form:radiobuttons path="availability" itemValue="NOT_AVAILABLE"  itemLabel="NOT_AVAILABLE"/>
<form:radiobuttons path="availability" itemValue="AVAILABLE"  itemLabel="AVAILABLE"/><br>
About<form:input path="about"/><br>
Price<form:input path="price"/><br>
<button type="submit">Create FoodProduct</button>
</form:form>

</body>
</html>