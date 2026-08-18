<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<title>Search Course</title>
</head>

<body>

	<h2>Search Course by ID</h2>

	<form action="${pageContext.request.contextPath}/searchCourseById"
		method="get">

		Course ID: <input type="number" name="courseId" required>

		<button type="submit">Search</button>

	</form>

	<c:if test="${not empty errorMessage}">
		<p style="color: red;">${errorMessage}</p>
	</c:if>

	<c:if test="${not empty course}">

		<h3>Course Details</h3>

		<table border="1">
			<tr>
				<th>ID</th>
				<td>${course.courseId}</td>
			</tr>

			<tr>
				<th>Course Name</th>
				<td>${course.courseName}</td>
			</tr>

			<tr>
				<th>Trainer Name</th>
				<td>${course.trainerName}</td>
			</tr>

			<tr>
				<th>Duration</th>
				<td>${course.duration}</td>
			</tr>

			<tr>
				<th>Fee</th>
				<td>${course.fee}</td>
			</tr>

			<tr>
				<th>Mode</th>
				<td>${course.mode}</td>
			</tr>

			<tr>
				<th>Batch Timing</th>
				<td>${course.batchTiming}</td>
			</tr>
		</table>

	</c:if>

	<br>

	<a href="${pageContext.request.contextPath}/viewCourse"> Back to
		Course List </a>

</body>
</html>