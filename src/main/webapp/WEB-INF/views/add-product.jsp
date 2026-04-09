<%@ include file="header.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="form-container">

<h2>Add Product</h2>

<form action="/save-product" method="post">

Name:

<input type="text" name="name" required>

Price:

<input type="number" name="price" required>

Image Name:

<input type="text" name="image" required>

<br><br>

<button type="submit">Save Product</button>

</form>

</div>

<style>

.form-container{
width:400px;
margin:auto;
padding:40px;
}

input{
width:100%;
padding:8px;
margin:10px 0;
}

button{
background:#28a745;
color:white;
padding:10px 20px;
border:none;
}

</style>

<%@ include file="footer.jsp" %>