<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<h1>What is your question?</h1>
<form:form method="POST" action="questions/new" modelAttribute="question">
<p>
<form:label path="question">Question:</form:label>
<form:errors path="question" />
<form:textarea path="question" />
</p>
<button>Submit</button>
</form:form>
</body>
</html>