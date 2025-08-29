<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="styles/style-main.css">
</head>
<body>
<div class="container">
    <h2>Admin Dashboard</h2>

    <form action="users/create-form" method="post" style="display:inline;">
        <button type="submit">Create</button>
    </form>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Email</th>
            <th>Position</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>${user.position}</td>
                <td>
                    <form action="users/delete" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit">Delete</button>
                    </form>

                    <form action="users/edit-form" method="post" style="display:inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit">Change</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form action="users/logout" method="post" style="display:inline;">
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
