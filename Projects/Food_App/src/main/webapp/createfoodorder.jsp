<%@page import="com.tyss.food_app.entity.Food_Product"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.food_app.serviceimplementation.Food_ProductServiceImplementation"%>
<%@page import="com.tyss.food_app.entity.FoodOder"%>
<%@page import="com.tyss.food_app.serviceimplementation.ItemServiceImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <!-- <style>
        #user{
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 150px;
        }
    </style> -->
</head>
<body>
    <form action="createFood" method="post" id=user>

        <table id=user>
            <tr>
                <td><label for="status">Status</label></td>
                <td><input type="text" id="status" name="status"></td>
            </tr>
            <br>
            <br>
            <tr>
                <td><label for="name">Customer Name</label></td>
                <td><input type="text" id="name" name="name"></td>
            </tr>
            <br>
            <br>
            <tr>
                <td><label for="phno">Customer Phone Number</label></td>
                <td><input type="tel" id="phno" name="phno"></td>
            </tr>
           <!--  <tr>
                <td><label for="tot">Total price</label></td>
                <td><input type="number" id="tot" name="tot"></td>
            </tr> -->
            <br>
            <br>
            <tr>
                <td colspan="2px" align="center"><input type="submit" value="Submit"></td>
            </tr>
        </table>
        <br><br>
        <table id="items" border="">
        
        <tr>
        <th>Product Id</th>
        <th>Product Name</th>
        <th>Product Type</th>
        <th>Product Price</th>
        <th>Product Availability</th>
        <th>About</th>
        <th>Product Quantity</th>
        <th>Click To Add</th>
        </tr>
        
        <%
        
        Food_ProductServiceImplementation service = new Food_ProductServiceImplementation() ;
        List<Food_Product> list = service.getAllFood_ProductService() ;
        Food_Product prod = new Food_Product () ;      		
              for(Food_Product pro: list) { %>
              <tr>
              <td><%= pro.getId() %></td>
              <td><%= pro.getName() %></td>
              <td><%= pro.getType()%></td>
              <td><%= pro.getPrice()%></td>
              <td><%= pro.getAvailability()%></td>
              <td><%= pro.getAbout() %></td>
              <td><input type="number" name = "quan"></td>
              <td><input type="checkbox" name = "item" value="<%= pro.getId()%>"></td>
                </tr> 
                <% } %>
               <td colspan="2px" align="center"> <input type="submit" value = "submit"><!-- </td> -->
               <br><!-- tdcolspan="2px" align="center"> --><a href="manager.jsp" colspan="2px" align="center"><button>Back</button></a></td>
               
        </table>
    </form>
</body>
</html>