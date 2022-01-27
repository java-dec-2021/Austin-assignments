<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Details</title>
</head>
<body>
<h1><c:out value="${product.name}" /></h1>
<p><c:out value="${product.description}" /></p>
<p><c:out value="${product.price}" /></p>
<hr>
<h3>Categories:</h3>
<ul>
<c:forEach items="${product.categories}" var="cat">
<li>${cat.name}</li>
</c:forEach>
</ul>
<div>
<form method="POST" action="/products/${product.id}">
<select name="cats">
<c:forEach items="${notInProd}" var ="cat">
<option value="${cat.id}">${cat.name}</option>
</c:forEach>
</select>
<button>Add Category</button>
</form>
</div>
</body>
</html>