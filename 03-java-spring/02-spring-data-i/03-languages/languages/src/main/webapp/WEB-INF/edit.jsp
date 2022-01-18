<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<div>
<h1>Edit Language</h1>
<p>
<form method="POST" action="/delete/${language.  id}">
<input type="hidden" name="_method" value="delete">
<button>Delete</button></form> | <a href="/">Dashboard</a></p>
</div>
<hr>
<form:form action="/languages/edit/${language.id}" method="POST" modelAttribute="language">
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

<input type="hidden" name="_method" value="put">
<button>Update</button>
</form:form>
</body>
</html>