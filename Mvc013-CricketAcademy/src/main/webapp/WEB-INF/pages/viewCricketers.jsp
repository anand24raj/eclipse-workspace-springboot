<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Cricketers</title>
</head>

<body>

	<h1 style="color: red; text-align: center;">View Cricketers!</h1>

	<a href="${pageContext.request.contextPath}/addCricketer"> Add
		Cricketer </a>

	<br>
	<br>
	<table
		style="border: 1px solid black; border-collapse: collapse; width: 500px; margin: auto; text-align: center;">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Team</th>
			<th>Role</th>
			<th>Batting Style</th>
			<th>Jersey</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:if test="${empty list}">
			<tr>
				<td colspan="8" style="text-align: center;">>
					<h1 style="color: green; text-align: center;">No Cricketers
						Found !</h1>
				</td>
			</tr>
		</c:if>


		<c:forEach var="cric" items="${list}">

			<tr>

				<td>${cric.playerId}</td>

				<td>${cric.playerName}</td>

				<td>${cric.teamName}</td>

				<td>${cric.role}</td>

				<td>${cric.battingStyle}</td>

				<td>${cric.jerseyNumber}</td>


				<td><a
					href="${pageContext.request.contextPath}/editCricketer/${cric.playerId}">
						Edit </a></td>


				<td><a
					href="${pageContext.request.contextPath}/deleteCricketer/${cric.playerId}"
					onclick="return confirm('Are you sure you want to delete this cricketer?');">
						Delete </a></td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>