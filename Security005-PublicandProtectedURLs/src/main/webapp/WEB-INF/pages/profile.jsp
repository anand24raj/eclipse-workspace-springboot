<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>

	<h1 style="color: red; ">${message}</h1>

	<p style="color: blue; ">You must be logged in to access this page.</p>

	<a href="${pageContext.request.contextPath}/dashboard" style="color: green; "> Dashboard </a>

	<br>
	<br>

	<form action="${pageContext.request.contextPath}/logout" method="post">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="submit" value="Logout">

	</form>

</body>
</html>