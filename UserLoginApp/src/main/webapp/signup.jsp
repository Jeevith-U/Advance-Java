<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        table{
        /* border: 2px solid;
        border-radius: 5px ; */
        width: 25%;
        margin: auto;
        margin-top: 5px;
        display: flex; 
        flex-direction: column;
        align-items: center;
        justify-content: space-around;
        /* padding-top: -200px ; */
        }
        
        tr{
        /* margin-top: -250px ; */
        }
        .data{
            margin-top: 5px;
        }
        
        </style>
</head>
<body>

    <div align=" center">

        <h1 align = "center">Welcome to User Login</h1>

        <form action="signup" method="post" border = "" id = "table">

            <table>
                <div class="data">
                
                <tr>
                    <td><label for="name">Name</label></td>
                    <td><input type="text" id="name" name="name"></td>
                </tr>
                <br>
                <br>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="email" id="email" name="email"></td>
                </tr>
                <tr>
                    <td><label for="pass">Password</label></td>
                    <td><input type="password" id="pass" name="pass"></td>
                </tr>
                <br>
                <br>
                <tr>
                    <td><label for="phone">Phone Number</label></td>
                    <td><input type="tel" id="phone" name="phone"></td>
                </tr>
                <br>
                <br>
                <tr>
                    <td style="margin-left: 50px;"><input type="submit" value="Submit"></td>
                </tr>
            </div>
            </table>
        </form>
    </div>
    
</body>
</html>