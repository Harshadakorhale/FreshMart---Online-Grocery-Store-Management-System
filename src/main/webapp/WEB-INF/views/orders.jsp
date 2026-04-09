<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container mt-4">

<h2 class="text-success text-center">My Orders </h2>
<c:if test="${not empty success}">
    <div style="color:green;
                background:#e6ffe6;
                padding:10px;
                border-radius:6px;
                margin-bottom:15px;
                font-weight:bold;">
        ${success}
    </div>
</c:if>
<table class="table table-bordered mt-4 text-center">

<tr class="table-success">
    <th>Order ID</th>
    <th>Total</th>
    <th>Status</th>
    <th>Address</th>
</tr>

<c:forEach var="o" items="${orders}">
<tr>
    <td>${o.orderId}</td>
    <td>₹${o.totalAmount}</td>
    <td>${o.status}</td>
    <td>${o.address}</td>
</tr>
</c:forEach>

</table>

</div>

<%@ include file="footer.jsp" %>