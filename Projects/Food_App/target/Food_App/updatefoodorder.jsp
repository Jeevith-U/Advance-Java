<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Order Update</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #d0c5c3;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 400px;
            width: 100%;
        }

        h1 {
            color: #007bff;
            font-size: 24px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        tr {
            margin-bottom: 10px;
        }

        td {
            padding: 10px;
            text-align: left;
        }

        label {
            font-weight: bold;
        }

        input[type="number"],
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
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
</head>
<body>
    <form action="updatefoodorder" method="post">
        <h1>Food Order Updation Page</h1>
        <table>
            <tr>
                <td><label for="id">Order ID:</label></td>
                <td><input type="number" id="id" name="id"></td>
            </tr>
            <tr>
                <td><label for="status">New Status:</label></td>
                <td><input type="text" id="status" name="status"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
            <tr>
                <td colspan="2"><a href="staff.jsp"><button>Back</button></a></td>
            </tr>
        </table>
    </form>
</body>
</html>
