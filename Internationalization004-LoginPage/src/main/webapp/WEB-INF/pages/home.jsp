<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
body {
	font-family: Arial;
	background: #eef2f7;
	text-align: center;
	padding-top: 100px;
}

a {
	background: #174f91;
	color: white;
	padding: 12px 25px;
	text-decoration: none;
	border-radius: 5px;
}
</style>

</head>

<body>

	<h1>Welcome</h1>

	<a href="${pageContext.request.contextPath}/login"> Login </a>

</body>
</html>