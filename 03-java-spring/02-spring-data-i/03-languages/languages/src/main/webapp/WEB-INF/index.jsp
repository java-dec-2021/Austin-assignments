<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
<h1>Languages Assignment</h1>
<hr>
<table border=1>
<thead>
<tr>
<td>Language Name</td>
<td>Creator</td>
<td>Version</td>
<td>Actions</td>
</tr>
</thead>
<tbody>
<c:forEach items="${allLanguages}" var="lang">
<tr>
<td><a href="/languages/${lang.id}">${lang.name}</a></td>
<td>${lang.creator}</td>
<td>${lang.currentVersion}</td>
<td><a href="/languages/edit/${lang.id}">Edit</a> | <form method="POST" action="/delete/${lang.id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button></form></td>
</tr>
</c:forEach>
</tbody>
</table>

<h3>Create New Language</h3>
<form:form action="/" method="POST" modelAttribute="language">
<p>
<form:label path="name">Name:</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>
<p>
<form:label path="creator">Creator:</form:label>
<form:errors path="creator"/>
<form:input path="creator"/> 
</p>
<p>
<form:label path="currentVersion">Current Version:</form:label>
<form:errors path="currentVersion"/>
<form:input path="currentVersion"/>
</p>
<button>Create</button>
</form:form>
</body>
</html>