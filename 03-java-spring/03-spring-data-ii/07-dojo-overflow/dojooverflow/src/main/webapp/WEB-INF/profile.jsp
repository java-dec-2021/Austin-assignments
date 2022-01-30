<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question Profile</title>
</head>
<body>
<h1>The Question itself - need logic</h1>
<h3>Tags:</h3>
<p>
<table>
<thead>
<tr>
<th>Answers</th>
</tr>
</thead>
</table>
<h3>Add your answer:</h3>
<form method="POST" action="/questions/addAnswer">
<label for="answer">Answer:</label>
<textarea></textarea>
<button>Answer it</button>
</form>
</p>
</body>
</html>