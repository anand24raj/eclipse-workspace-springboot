<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About</title>
</head>
<body>

	<h1 style="color: green; ">${message}</h1>

	<p style="color: blue; "> This page is accessible without login.</p>

	<a href="${pageContext.request.contextPath}/" style="color: yellow;"> Home </a>

</body>
</html>