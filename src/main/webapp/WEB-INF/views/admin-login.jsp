<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FreshMart Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css?v=20260330">
</head>
<body class="admin-login-body">
<div class="admin-login-card">
    <h1>FreshMart Admin</h1>
    <p>Sign in to access dashboard</p>

    <c:if test="${not empty error}">
        <div class="error-box">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/admin/login" method="post">
        <label>Username or Email</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>

        <button type="submit" class="primary-btn full">Login</button>
    </form>
</div>
</body>
</html>
