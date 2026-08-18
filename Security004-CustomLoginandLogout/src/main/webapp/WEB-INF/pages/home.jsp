<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>

	<h1 style="color: red; text-align: center;">${message}</h1>

	<p style="color: green; text-align: center;">You are successfully
		logged in.</p>

	<form action="${pageContext.request.contextPath}/logout" method="post"
		style="text-align: center;">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="submit" value="Logout">

	</form>

</body>
</html>