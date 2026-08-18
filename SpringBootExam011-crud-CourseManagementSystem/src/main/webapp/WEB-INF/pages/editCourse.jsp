<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Course</title>
</head>

<body>

	<h2>Edit Course</h2>

	<form:form action="${pageContext.request.contextPath}/updateCourse"
		method="post" modelAttribute="course">

		<form:hidden path="courseId" />

    Course Name:
    <form:input path="courseName" />
		<br>
		<br>

    Trainer Name:
    <form:input path="trainerName" />
		<br>
		<br>

    Duration:
    <form:input path="duration" />
		<br>
		<br>

    Fee:
    <form:input path="fee" />
		<br>
		<br>

    Mode:
    <form:select path="mode">
			<form:option value="Online">Online</form:option>
			<form:option value="Offline">Offline</form:option>
			<form:option value="Hybrid">Hybrid</form:option>
		</form:select>
		<br>
		<br>

    Batch Timing:
    <form:input path="batchTiming" />
		<br>
		<br>

		<button type="submit">Update Course</button>

	</form:form>

	<br>

	<a href="${pageContext.request.contextPath}/viewCourse"> Back to
		Course List </a>

</body>
</html>