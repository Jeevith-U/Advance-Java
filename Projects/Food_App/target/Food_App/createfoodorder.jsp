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
    <title>Food Order Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8ccfb;
            margin: 0;
            padding: 0;
        }

        #user {
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 900px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: #fff;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="tel"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="checkbox"] {
            margin-right: 5px;
        }

        input[type="submit"],
        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        button:hover {
            background-color: #0056b3;
        }

        a {
            text-decoration: none;
            color: #007bff;
        }

        button a {
            color: #fff;
        }

        /* Reduce the size of the product quantity input */
        .quantity-input {
            width: 60px;
        }

        /* Center the product quantity input */
        .quantity-td {
            text-align: center;
        }
    </style>
    <% response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate"); %>
</head>
<body>
    <form action="createFood" method="post" id="user">
        <table>
            <tr>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Type</th>
                <th>Product Price</th>
                <th>Product Availability</th>
                <th>About</th>
                <th class="quantity-td">Product Quantity</th>
                <th>Add to Cart</th>
            </tr>
            <%
                Food_ProductServiceImplementation service = new Food_ProductServiceImplementation();
                List<Food_Product> list = service.getAllFood_ProductService();
                Food_Product prod = new Food_Product();
                for (Food_Product pro : list) { %>
                    <tr>
                        <td><%= pro.getId() %></td>
                        <td><%= pro.getName() %></td>
                        <td><%= pro.getType() %></td>
                        <td><%= pro.getPrice() %></td>
                        <td><%= pro.getAvailability() %></td>
                        <td><%= pro.getAbout() %></td>
                        <td class="quantity-td"><input type="number" name="quan" class="quantity-input"></td>
                        <td><input type="checkbox" name="item" value="<%= pro.getId() %>"></td>
                    </tr>
                <% } %>
            </table>
            <br>
            <input type="submit" value="Submit">
            <a href="manager.jsp"><button>Back</button></a>
        </form>
    </body>
    </html>
