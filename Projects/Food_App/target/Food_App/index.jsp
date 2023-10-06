<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to Our Website</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .header {
            text-align: center;
            margin-bottom: 20px;
        }

        .header h1 {
            font-size: 36px;
            color: #333;
        }

        .action-buttons {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 20px;
            margin-top: 20px;
        }

        .action-button {
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s ease;
        }

        .action-button:hover {
            background-color: #0056b3;
        }
    </style>
    <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to Food App</h1>
            <p>Discover our amazing services</p>
        </div>
        <div class="action-buttons">
            <a href="SignUp.jsp" class="action-button">Sign Up</a>
            <a href="Login.jsp" class="action-button">Login</a>
        </div>
    </div>
</body>
</html>
