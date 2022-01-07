<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css">
<script href="js/main.js"></script>
<title>Dojo Survey</title>
</head>
<body>
<h1>Dojo Survey</h1>
<form class="container" method="post" action="/result">
<p>
<label>Your Name: </label>
<input type="text" name="name">
</p>
<p>
<label>Dojo Location: </label> 
<select name="location">
<option value="Bellevue">Bellevue</option>
<option value="San Jose">San Jose</option>
<option value="Online"> Online</option>
</select>
</p>
<p>
<label>Favorite Language:</label>
<select name="language">
<option value="Java">Java</option>
<option value="MERN">MERN</option>
<option value="Python">Python</option>
</select>
</p>
<p>
<label>Comments (optional):</label>
</p>
<p>
<textarea rows="10" cols="40" name="comment"></textarea>
</p>
<p>
<button type="submit">Submit</button>
</p>
</form>
</body>
</html>