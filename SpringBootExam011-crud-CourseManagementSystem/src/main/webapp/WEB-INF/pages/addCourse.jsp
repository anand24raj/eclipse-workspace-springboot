<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Add Course</title>
</head>
<body>

	<h2>Add New Course</h2>

	<form:form action="${pageContext.request.contextPath}/saveCourse"
		method="post" modelAttribute="course">

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
			<form:option value="" label="Select Mode" />
			<form:option value="Online" label="Online" />
			<form:option value="Offline" label="Offline" />
			<form:option value="Hybrid" label="Hybrid" />
		</form:select>
		<br>
		<br>

    Batch Timing:
    <form:input path="batchTiming" />
		<br>
		<br>

		<button type="submit">Add Course</button>

	</form:form>

	<br>

	<a href="${pageContext.request.contextPath}/viewCourse"> View All
		Courses </a>

</body>
</html>