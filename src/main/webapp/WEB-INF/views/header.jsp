<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>FreshMart</title>

    <!-- ✅ Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- ✅ Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?v=20260330">
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-success shadow-sm">
    <div class="container-fluid">
        <a class="navbar-brand fw-bold text-white" href="${pageContext.request.contextPath}/">FreshMart</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNavbar" aria-controls="mainNavbar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="mainNavbar">
            <div class="d-flex flex-column flex-lg-row align-items-lg-center gap-2 mt-3 mt-lg-0">
                <a class="btn btn-light btn-sm btn-nav" href="${pageContext.request.contextPath}/">Home</a>
                <a class="btn btn-light btn-sm btn-nav" href="${pageContext.request.contextPath}/products">Products</a>

                <c:if test="${loggedUser != null}">
                    <a href="${pageContext.request.contextPath}/cart" class="btn btn-light btn-sm btn-nav position-relative">
                        Cart
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            ${cartCount}
                        </span>
                    </a>
                    <a class="btn btn-outline-light btn-sm btn-nav" href="${pageContext.request.contextPath}/orders">Orders</a>
                    <span class="text-white small px-1">Welcome, ${loggedUser.name}</span>
                    <a class="btn btn-danger btn-sm btn-nav" href="${pageContext.request.contextPath}/logout">Logout</a>
                </c:if>

                <c:if test="${loggedUser == null}">
                    <a class="btn btn-warning btn-sm btn-nav" href="${pageContext.request.contextPath}/login">Login</a>
                    <a class="btn btn-warning btn-sm btn-nav" href="${pageContext.request.contextPath}/register">Register</a>
                </c:if>
            </div>
        </div>
    </div>
</nav>

<main class="container site-main py-4">