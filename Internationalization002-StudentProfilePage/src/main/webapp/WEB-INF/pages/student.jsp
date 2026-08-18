<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
</head>

<body>

	<div style="text-align: right;">
		<a href="${pageContext.request.contextPath}/student?lang=en">
			English </a> | <a
			href="${pageContext.request.contextPath}/student?lang=hi"> हिन्दी
		</a>
	</div>

	<h1 style="color: blue; text-align: center;">
		<spring:message code="title" />
	</h1>

	<p>
		<b><spring:message code="student" /> :</b> ${studentName}
	</p>

	<p>
		<b><spring:message code="course" /> :</b> ${courseName}
	</p>

	<p>
		<spring:message code="thank" />
	</p>

</body>
</html>