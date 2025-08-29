<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="styles/style-main.css">
</head>
<body>
<div class="container">
    <h2>
        <c:choose>
            <c:when test="${param.action == 'edit'}">Edit User</c:when>
            <c:otherwise>Create User</c:otherwise>
        </c:choose>
    </h2>



    <form method="post" action="users/${param.action == 'edit' ? 'edit' : 'create'}">
        <input type="hidden" name="id" value="${editingUser.id}"><br>

        <label>Firstname</label>
        <input type="text" name="firstName"
               value="${param.action == 'edit' ? editingUser.firstName : ''}" required><br>

        <label>Lastname</label>
        <input type="text" name="surname"
               value="${param.action == 'edit' ? editingUser.surname : ''}" required><br>

        <label>Email</label>
        <input type="email" name="email"
               value="${param.action == 'edit' ? editingUser.email : ''}" required><br>

        <label>Password</label>
        <input type="password" name="password"
               value="${param.action == 'edit' ? editingUser.password : ''}" required><br>

        <label>Position:</label>
        <select name="position" required>
            <c:forEach var="pos" items="${positions}">
                <option value="${pos}">${pos}</option>
            </c:forEach>
        </select>
        <br>

        <button type="submit">
            <c:choose>
                <c:when test="${param.action == 'edit'}">Update</c:when>
                <c:otherwise>Create</c:otherwise>
            </c:choose>
        </button>
    </form>
</div>
</body>
</html>
