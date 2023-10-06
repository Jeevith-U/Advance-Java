<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Food Order Lookup</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to bottom, #007bff, #0056b3);
            color: white;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: rgba(255, 255, 255, 0.2);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        table {
            width: 100%;
            margin-bottom: 10px;
        }

        td {
            padding: 10px;
            text-align: center;
        }

        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
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
            text-decoration: none;
        }
    </style>
    <% response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate"); %>
</head>
<body>
    <form action="displayfoodorder" method="post">
        <table>
            <tr>
                <td>Enter the Id:</td>
                <td><input type="number" name="id"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"></td>
            </tr>
            <tr>
                <td colspan="2"><a href="staff.jsp"><button>Back</button></a></td>
            </tr>
        </table>
    </form>
</body>
</html>
