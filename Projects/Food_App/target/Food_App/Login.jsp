<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cooking Staff Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #64beb9; /* Light blue background color */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 400px; /* Limit container width */
            width: 100%; /* Take full width */
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            font-size: 18px;
            display: block; /* Display labels as blocks for better alignment */
            text-align: left; /* Left-align labels */
            margin-bottom: 5px; /* Add spacing between labels and inputs */
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .cooking-image {
            max-width: 100%;
            height: auto;
            margin-top: 20px;
        }
    </style>
    <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
</head>
<body>
    <div class="container">
        <h1>Cooking Staff Login</h1>
        <img src="cooking-image.jpg" alt="Cooking Staff" class="cooking-image">
        <form action="login" method="post">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
            <label for="pass">Password:</label>
            <input type="password" id="pass" name="pass" required>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
