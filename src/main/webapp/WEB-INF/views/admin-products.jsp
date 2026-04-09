<%@ include file="admin-header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="admin-title-row">
    <h1>Manage Products</h1>
    <a href="${pageContext.request.contextPath}/admin/products/new" class="primary-btn">+ Add Product</a>
</section>

<div class="table-wrap">
    <table class="admin-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Qty</th>
            <th>Image</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.productId}</td>
                <td>${p.name}</td>
                <td>${p.category}</td>
                <td>₹${p.price}</td>
                <td>${p.quantity}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/images/${p.imageUrl}" width="64" height="64" style="object-fit:cover;border-radius:8px;" alt="${p.name}">
                </td>
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/admin/products/edit/${p.productId}" class="table-link edit">Edit</a>
                    <a href="${pageContext.request.contextPath}/admin/products/delete/${p.productId}" class="table-link delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="admin-footer.jsp" %>