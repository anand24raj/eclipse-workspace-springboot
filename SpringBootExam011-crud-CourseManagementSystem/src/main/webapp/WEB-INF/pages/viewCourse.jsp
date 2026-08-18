<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<title>Course Management System</title>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	border: 1px solid black;
	padding: 8px;
	text-align: center;
}

th {
	background-color: lightgray;
}
</style>
</head>

<body>

	<h1>Course Management System</h1>

	<a href="${pageContext.request.contextPath}/addCourse"> Add New
		Course </a> &nbsp;&nbsp;

	<a href="${pageContext.request.contextPath}/searchCourse"> Search
		Course </a>

	<br>
	<br>

	<c:if test="${not empty message}">
		<p style="color: green;">${message}</p>
	</c:if>

	<c:if test="${not empty errorMessage}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>

	<table>

		<tr>
			<th>ID</th>
			<th>Course Name</th>
			<th>Trainer Name</th>
			<th>Duration</th>
			<th>Fee</th>
			<th>Mode</th>
			<th>Batch Timing</th>
			<th>Action</th>
		</tr>

		<c:forEach var="course" items="${courseList}">

			<tr>
				<td>${course.courseId}</td>
				<td>${course.courseName}</td>
				<td>${course.trainerName}</td>
				<td>${course.duration}</td>
				<td>${course.fee}</td>
				<td>${course.mode}</td>
				<td>${course.batchTiming}</td>

				<td><a
					href="${pageContext.request.contextPath}/editCourse/${course.courseId}">
						Edit </a> &nbsp;&nbsp; <a
					href="${pageContext.request.contextPath}/deleteCourse/${course.courseId}"
					onclick="return confirm('Are you sure you want to delete this course?');">
						Delete </a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>