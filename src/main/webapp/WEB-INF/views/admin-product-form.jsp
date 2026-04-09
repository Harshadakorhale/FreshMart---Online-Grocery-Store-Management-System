<%@ include file="admin-header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="admin-title-row">
    <h1><c:if test="${formMode == 'edit'}">Edit Product</c:if><c:if test="${formMode == 'create'}">Add Product</c:if></h1>
</section>

<div class="form-card">
    <form method="post" action="${pageContext.request.contextPath}/admin/products<c:if test='${formMode == "edit"}'>/update</c:if>">
        <c:if test="${formMode == 'edit'}">
            <input type="hidden" name="productId" value="${product.productId}">
        </c:if>

        <label>Name</label>
        <input type="text" name="name" value="${product.name}" required>

        <label>Category</label>
        <input type="text" name="category" value="${product.category}" required>

        <label>Price</label>
        <input type="number" step="0.01" min="0" name="price" value="${product.price}" required>

        <label>Quantity</label>
        <input type="number" min="0" name="quantity" value="${product.quantity}" required>

        <label>Image URL</label>
        <input type="text" name="imageUrl" value="${product.imageUrl}" required>

        <label>Description</label>
        <textarea name="description" rows="4" required>${product.description}</textarea>

        <button type="submit" class="primary-btn">Save Product</button>
    </form>
</div>

<%@ include file="admin-footer.jsp" %>
