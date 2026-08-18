<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h1 style="color: red; ">${message}</h1>

	<p style="color: green; ">This page is accessible without login.</p>

	<a href="${pageContext.request.contextPath}/about" style="color: blue; "> About </a>

	<br>
	<br>

	<a href="${pageContext.request.contextPath}/dashboard" style="color: green; "> Dashboard </a>

	<br>
	<br>

	<a href="${pageContext.request.contextPath}/profile" style="color: red; "> Profile </a>

</body>
</html>