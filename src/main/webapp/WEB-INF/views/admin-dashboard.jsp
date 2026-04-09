<%@ include file="admin-header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="admin-title-row">
    <h1>Dashboard</h1>
    <p>Welcome back. Track and manage FreshMart operations from one place.</p>
</section>

<section class="stat-grid">
    <article class="stat-card">
        <h3>Total Products</h3>
        <p>${productCount}</p>
    </article>
    <article class="stat-card">
        <h3>Total Customers</h3>
        <p>${customerCount}</p>
    </article>
</section>

<section class="quick-actions">
    <a href="${pageContext.request.contextPath}/admin/products/new" class="primary-btn">Add New Product</a>
    <a href="${pageContext.request.contextPath}/admin/products" class="secondary-btn">Manage Products</a>
    <a href="${pageContext.request.contextPath}/admin/orders" class="secondary-btn">Manage Orders</a>
    <a href="${pageContext.request.contextPath}/admin/customers" class="secondary-btn">View Customers</a>
</section>

<%@ include file="admin-footer.jsp" %>