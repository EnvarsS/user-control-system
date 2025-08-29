<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="styles/style-main.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>Email:</label>
        <input type="email" name="email" required><br>

        <label>Password:</label>
        <input type="password" name="password" required><br>

        <button type="submit">Login</button>
    </form>
</div>
</body>
</html>
