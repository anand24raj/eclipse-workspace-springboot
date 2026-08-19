<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout</title>

<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	padding-top: 100px;
	background-color: #f5f5f5;
}

.container {
	width: 400px;
	margin: auto;
	padding: 40px;
	background: white;
	border-radius: 10px;
	box-shadow: 0 0 10px #ccc;
}

h1 {
	color: green;
}

.login-link {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 20px;
	background-color: #007bff;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}
</style>
</head>
<body>

	<h1>Logout Successful</h1>

	<p>You have been successfully logged out.</p>

	<a href="${pageContext.request.contextPath}/login">
		<button>Login Again</button>
	</a>

</body>
</html>