<%@ include file="admin-header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="admin-title-row">
    <h1>Customers</h1>
    <p>Registered users in FreshMart.</p>
</section>

<div class="table-wrap">
    <table class="admin-table">
        <thead>
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <th>Username</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="c">
            <tr>
                <td>${c.userId}</td>
                <td>${c.name}</td>
                <td>${c.username}</td>
                <td>${c.email}</td>
                <td>${c.role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="admin-footer.jsp" %>
