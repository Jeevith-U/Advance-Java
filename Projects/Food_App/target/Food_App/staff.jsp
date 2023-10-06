<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Staff</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            margin: 20px; /* Add space on both sides */
            display: inline-block;
        }

        h2 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            font-size: 18px;
            display: block;
            text-align: left;
            margin-bottom: 10px;
        }

        input[type="radio"] {
            margin-right: 10px;
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

        button {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            margin-left: 10px;
            text-decoration: none;
        }

        button a {
            color: #fff;
            text-decoration: none;
        }
    </style>
    <% response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate"); %>
</head>
<body>
    <div class="form-container">
        <h2>Staff Operations</h2>
        <form action="staffop" method="post">
            <label><input type="radio" name="op" value="create"> Create Food Order</label><br>
            <label><input type="radio" name="op" value="find"> Find Food Order</label><br>
            <label><input type="radio" name="op" value="update"> Update Food Order</label><br>
            <label><input type="radio" name="op" value="get"> Get All Food Orders</label><br>
            <label><input type="radio" name="op" value="delete"> Delete Food Order</label><br>
            <input type="submit" value="Submit">
            <button><a href="Login.jsp">Back</a></button>
        </form>
    </div>
</body>
</html>
