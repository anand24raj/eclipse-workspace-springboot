<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title><spring:message code="home.title" /></title>

<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f3f6fa;
	margin: 0;
	padding: 0;
}

.container {
	width: 500px;
	margin: 100px auto;
	padding: 35px;
	background-color: white;
	text-align: center;
	border-radius: 10px;
	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
}

h1 {
	color: #1e5aa8;
}

.message {
	font-size: 22px;
	margin: 18px;
}

.languages {
	margin-top: 30px;
}

.languages a {
	display: inline-block;
	padding: 10px 20px;
	margin: 5px;
	color: white;
	background-color: #1e5aa8;
	text-decoration: none;
	border-radius: 5px;
}

.languages a:hover {
	background-color: #143f78;
}
</style>
</head>

<body>

	<div class="container">

		<h1>
			<spring:message code="home.heading" />
		</h1>

		<div class="message">
			<spring:message code="home.morning" />
		</div>

		<div class="message">
			<spring:message code="home.thanks" />
		</div>

		<div class="languages">

			<a href="${pageContext.request.contextPath}/home?lang=en">
				English </a> <a href="${pageContext.request.contextPath}/home?lang=hi">
				हिन्दी </a>

		</div>

	</div>

</body>
</html>