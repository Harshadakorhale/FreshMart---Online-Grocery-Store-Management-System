<%@ include file="admin-header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="admin-title-row">
    <h1>Manage Orders</h1>
    <p>Track all customer orders in one place.</p>
</section>

<div class="table-wrap">
    <table class="admin-table">
        <thead>
        <tr>
            <th>Order ID</th>
            <th>User ID</th>
            <th>Total</th>
            <th>Status</th>
            <th>Address</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${orders}" var="o">
            <tr>
                <td>${o.orderId}</td>
                <td>${o.userId}</td>
                <td>₹${o.totalAmount}</td>
                <td>${o.status}</td>
                <td class="url-cell">${o.address}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="admin-footer.jsp" %>
