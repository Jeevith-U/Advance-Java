<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        table{
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 150px;
        }
    </style>
</head>
<body>
    <form action="updatefoodorder" method="post">

        <h1 align="center">Welecom to Food Order Updation Page</h1>

        <table>
            <tr>
                <td><label for="id">Enter The Order Id</label></td>
                <td><input type="number" id="id" name="id"></td>
            </tr>
            <tr>
                <td><label for="status">Enter The Status</label></td>
                <td><input type="text" id="status" name="status"></td>
            </tr>
            <td colspan="2px" align="center"><input type="submit" value="submit"></td>
             <td colspan="2px" align="center"><a href="staff.jsp"><button>Back</button></a></td>
        </table>
    </form>
</body>
</html>