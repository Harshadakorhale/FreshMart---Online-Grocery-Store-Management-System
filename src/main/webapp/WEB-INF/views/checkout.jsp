<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container mt-4">

<h2 class="text-success text-center">Checkout </h2>

<div class="card p-4 shadow mt-4">

    <h4>Total Amount: ₹${total}</h4>

    <form action="${pageContext.request.contextPath}/place-order" method="post" class="mt-3">

        <label>Delivery Address:</label>
        <textarea name="address" class="form-control" required></textarea>

        <button class="btn btn-success mt-3 w-100">Place Order </button>
    </form>

</div>

</div>

<%@ include file="footer.jsp" %>