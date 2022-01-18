<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Page</title>
</head>
<body>
<div>
<h1>${thisLang.name}'s Details</h1>
<a href="/">Dashboard</a>
</div>
<hr>
<p><c:out value="${thisLang.name}"/></p>
<p><c:out value="${thisLang.creator}"/></p>
<p><c:out value="${thisLang.currentVersion}"/></p>
<p><a href="/languages/edit/${thisLang.id}">Edit</a> | <form method="POST" action="/delete/${id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button></form>
</body>
</html>