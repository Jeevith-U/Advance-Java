<%@page import="com.tyss.food_app.entity.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.food_app.serviceimplementation.BranchServiceImplementation"%>
<%@page import="com.tyss.food_app.userDaoImplementation.BranchDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
table{

display: flex ;
justify-content: center;
align-items: center;

}

</style>
</head>
<body>

<table border="">

<tr>
<th>Branch Id</th>
<th>Branch Name</th>
<th>Branch Phone Number</th>
<th>Branch Email</th>
<th>Branch Address</th>

</tr>

<% BranchServiceImplementation dao = new BranchServiceImplementation () ;
   List<Branch> list = dao.getAllBranchervice() ;
   for(Branch branch : list) { %>
   
   <tr>
   <td><%= branch.getId() %></td>
   <td><%= branch.getName()%></td>
   <td><%= branch.getPhno()%></td>
   <td><%= branch.getEmail()%></td>
   <td><%= branch.getAddress()%></td>
   </tr>
   
   <% } %>
  <tr> <td><a href="manager.jsp" colspan="2px" align="center"><button>Back</button></a></td> </tr>
</table>
</body>
</html>