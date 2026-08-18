<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<h2 style="color: red; ">Login Required</h2>

	<form action="${pageContext.request.contextPath}/login" method="post">

		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> Username: <input type="text"
			name="username" required> <br>
		<br> Password: <input type="password" name="password" required>

		<br>
		<br> <input type="submit" value="Login">

	</form>

	<%
	if (request.getParameter("error") != null) {
	%>
	<p style="color: red;">Invalid username or password.</p>
	<%
	}
	%>

	<%
	if (request.getParameter("logout") != null) {
	%>
	<p style="color: green;">Logged out successfully.</p>
	<%
	}
	%>

</body>
</html>