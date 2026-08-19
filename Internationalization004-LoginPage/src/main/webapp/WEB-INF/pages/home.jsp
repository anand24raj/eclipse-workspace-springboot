
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f6f8;
	text-align: center;
	padding-top: 100px;
}

.container {
	background: white;
	width: 500px;
	margin: auto;
	padding: 40px;
	border-radius: 10px;
	box-shadow: 0 0 10px #ccc;
}

.success {
	color: green;
	font-size: 20px;
	margin-bottom: 20px;
}

h1 {
	color: #333;
}

.logout {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 30px;
	background-color: #dc3545;
	color: white;
	text-decoration: none;
	border-radius: 5px;
}

.logout:hover {
	background-color: #c82333;
}
</style>
</head>
<body>

	<h1>Welcome to Home Page</h1>

	<p>Login Successful!</p>

	<p>Welcome, ${username}</p>

	<a href="${pageContext.request.contextPath}/logout">
		<button>Logout</button>
	</a>

</body>
</html>
