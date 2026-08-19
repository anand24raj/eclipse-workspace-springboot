<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title><spring:message code="login.page.title" /></title>

<style>
body {
	margin: 0;
	background: #eef2f7;
	font-family: Arial, sans-serif;
}

.container {
	width: 400px;
	margin: 70px auto;
	padding: 35px;
	background: white;
	border-radius: 10px;
	box-shadow: 0 5px 18px gray;
}

h1 {
	text-align: center;
	color: #174f91;
}

.language-links {
	text-align: center;
	margin-bottom: 25px;
}

.language-links a {
	background: #174f91;
	color: white;
	padding: 8px 12px;
	margin: 3px;
	text-decoration: none;
	border-radius: 4px;
}

.form-group {
	margin-bottom: 18px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

input {
	width: 100%;
	padding: 10px;
	box-sizing: border-box;
}

.error {
	color: red;
	margin-top: 5px;
	display: block;
}

.buttons {
	display: flex;
	justify-content: space-between;
}

button {
	width: 48%;
	padding: 10px;
	border: none;
	color: white;
	cursor: pointer;
}

.login {
	background: #167444;
}

.reset {
	background: #777;
}
</style>

</head>

<body>

	<div class="container">

		<h1>
			<spring:message code="login.heading" />
		</h1>

		<!-- Language Selection -->

		<div class="language-links">

			<a href="${pageContext.request.contextPath}/login?lang=en">
				English </a> <a href="${pageContext.request.contextPath}/login?lang=hi">
				हिन्दी </a> <a href="${pageContext.request.contextPath}/login?lang=fr">
				Français </a>

		</div>


		<!-- Login Form -->

		<form:form method="post"
			action="${pageContext.request.contextPath}/login"
			modelAttribute="loginForm">

			<!-- Global errors -->

			<form:errors path="" cssClass="error" />


			<!-- Username -->

			<div class="form-group">

				<label> <spring:message code="login.username" />
				</label>

				<form:input path="username" />

				<form:errors path="username" cssClass="error" />

			</div>


			<!-- Password -->

			<div class="form-group">

				<label> <spring:message code="login.password" />
				</label>

				<form:password path="password"/>

				<form:errors path="password" cssClass="error" />

			</div>


			<!-- Buttons -->

			<div class="buttons">

				<button type="submit" class="login">
					<spring:message code="login.button" />
				</button>

				<button type="reset" class="reset">
					<spring:message code="login.reset" />
				</button>

			</div>

		</form:form>

	</div>

</body>

</html>