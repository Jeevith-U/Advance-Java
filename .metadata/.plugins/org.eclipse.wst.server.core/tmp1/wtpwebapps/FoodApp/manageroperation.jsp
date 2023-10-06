<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME Mr.${user.getName()} To BRANCHMANAGER PAGE</h1>
<h2>${msg}</h2>
<a href="createstaff"><button>CRATE STAFF</button></a>
<a href="createfoodproduct"><button>CRATE FOOD PRODUCT</button></a>


</body>
</html>