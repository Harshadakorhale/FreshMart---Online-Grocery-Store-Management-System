<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 class="text-center text-success mb-4">Fresh Grocery </h2>

<!-- CATEGORY BUTTONS -->
<div class="text-center mb-4">
    <a href="${pageContext.request.contextPath}/products?category=Fruits" class="btn btn-outline-success mx-2 mb-2">Fruits</a>
    <a href="${pageContext.request.contextPath}/products?category=Vegetables" class="btn btn-outline-success mx-2 mb-2">Vegetables</a>
    <a href="${pageContext.request.contextPath}/products?category=Dairy" class="btn btn-outline-success mx-2 mb-2">Dairy</a>
    <a href="${pageContext.request.contextPath}/products?category=Bakery" class="btn btn-outline-success mx-2 mb-2">Bakery</a>
    <a href="${pageContext.request.contextPath}/products?category=Snacks%20%26%20Desserts" class="btn btn-outline-success mx-2 mb-2">Snacks &amp; Desserts</a>
    <a href="${pageContext.request.contextPath}/products?category=Cold%20Beverages" class="btn btn-outline-success mx-2 mb-2">Cold Beverages</a>
</div>

<div class="row">
<c:forEach var="p" items="${products}">
    <div class="col-md-3 mb-4">

        <div class="card shadow">

            <!-- FIX IMAGE PATH -->
            <img src="${pageContext.request.contextPath}/images/${p.imageUrl}" class="card-img-top" alt="${p.name}">

            <div class="card-body text-center">
                <h5>${p.name}</h5>
                <p class="text-muted">${p.category}</p>
                <h6 class="text-success">₹${p.price}</h6>

                <form action="${pageContext.request.contextPath}/add-to-cart" method="post">
                    <input type="hidden" name="productId" value="${p.productId}">
                    <button class="btn btn-success w-100">Add to Cart 🛒</button>
                </form>
            </div>

        </div>

    </div>
</c:forEach>
</div>

<%@ include file="footer.jsp" %>