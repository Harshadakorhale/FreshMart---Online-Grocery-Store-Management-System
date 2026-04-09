<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FreshMart Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css?v=20260330">
</head>
<body>
<div class="admin-shell">
    <aside class="admin-sidebar">
        <h2>FreshMart</h2>
        <p class="admin-subtitle">Admin Panel</p>
        <nav>
            <a href="${pageContext.request.contextPath}/admin/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/admin/products">Products</a>
            <a href="${pageContext.request.contextPath}/admin/orders">Orders</a>
            <a href="${pageContext.request.contextPath}/admin/customers">Customers</a>
        </nav>
        <a class="logout-btn" href="${pageContext.request.contextPath}/admin/logout">Logout</a>
    </aside>
    <main class="admin-main">
