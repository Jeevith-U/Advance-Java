<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
     <style>
       /* form{
            
            display: flex;
            justify-content: center;
            align-items: center;
        } */
    </style>
</head>
<body>
    <form action="menuoperation" method="post" >

        <label>
            <input type="checkbox" name="option" value="find">
            Find Menu
        </label><br>
        <label>
            <input type="checkbox" name="option" value="update">
            Update Menu
        </label><br>
        <label>
            <input type="checkbox" name="option" value="details">
            Get All Menu
        </label><br>
        
        <label>
            <input type="checkbox" name="option" value="delete">
            Delete menu
        </label><br>

          <input type="submit" colspan="2" align="center" >

        </form>
</body>
</html>