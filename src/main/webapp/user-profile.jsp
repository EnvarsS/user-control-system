<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>User Profile</title>
    <link rel="stylesheet" href="styles/style-main.css">
</head>
<body>
<div class="container">
    <h2>User Profile</h2>

    <p><strong>Name:</strong> ${user.firstName}</p>
    <p><strong>Surname:</strong> ${user.surname}</p>
    <p><strong>Email:</strong> ${user.email}</p>
    <p><strong>Password:</strong> ${user.password}</p>
    <p><strong>Position:</strong> ${user.position}</p>

    <form action="users/logout" method="post" style="display:inline;">
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
