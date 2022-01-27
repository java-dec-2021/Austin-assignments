<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Details</title>
</head>
<body>
<h1><c:out value="${category.name}" /></h1>
<hr>
<h3>Products:</h3>
<ul>
<c:forEach items="${category.products}" var="prod">
<li>${prod.name}</li>
</c:forEach>
</ul>
<div>
<form method="POST" action="/categories/${category.id}">
<select name="prods">
<c:forEach items="${notInCat}" var ="prod">
<option value="${prod.id}">${prod.name}</option>
</c:forEach>
</select>
<button>Add Product</button>
</form>
</div>
</body>
</html>