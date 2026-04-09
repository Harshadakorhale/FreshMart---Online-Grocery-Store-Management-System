<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 class="text-center text-success mb-4">Your Cart </h2>

<div class="container">

<c:set var="total" value="0"/>

<c:forEach var="item" items="${cartItems}">

<div class="card mb-3 shadow p-3">

    <div class="row align-items-center">

        <!-- IMAGE -->
        <div class="col-md-2">
			<img src="${pageContext.request.contextPath}/images/${item.imageUrl}"
			     style="height:80px;width:80px;object-fit:cover;border-radius:10px;">
        </div>

        <!-- NAME -->
        <div class="col-md-3">
            <h5>${item.name}</h5>
        </div>

        <!-- PRICE -->
        <div class="col-md-2">
            ₹${item.price}
        </div>

        <!-- QUANTITY CONTROLS -->
        <div class="col-md-3 d-flex align-items-center">

            <!-- DECREASE -->
            <form action="${pageContext.request.contextPath}/decrease" method="post">
                <input type="hidden" name="productId" value="${item.productId}">
                <button class="btn btn-danger">-</button>
            </form>

            <span class="mx-3">${item.quantity}</span>

            <!-- INCREASE -->
            <form action="${pageContext.request.contextPath}/increase" method="post">
                <input type="hidden" name="productId" value="${item.productId}">
                <button class="btn btn-success">+</button>
            </form>

        </div>

        <!-- SUBTOTAL -->
        <div class="col-md-1">
            ₹${item.price * item.quantity}
        </div>

        <!-- REMOVE BUTTON -->
        <div class="col-md-1">
            <form action="${pageContext.request.contextPath}/remove" method="post">
                <input type="hidden" name="productId" value="${item.productId}">
                <button class="btn btn-dark">Remove</button>
            </form>
        </div>

    </div>

</div>

<c:set var="total" value="${total + (item.price * item.quantity)}"/>

</c:forEach>

<!-- TOTAL -->
<div class="text-end mt-4">
    <h4>Total: ₹${total}</h4>
   <a href="${pageContext.request.contextPath}/checkout" class="btn btn-success btn-lg">Proceed to Checkout</a>
</div>

</div>

<%@ include file="footer.jsp" %>