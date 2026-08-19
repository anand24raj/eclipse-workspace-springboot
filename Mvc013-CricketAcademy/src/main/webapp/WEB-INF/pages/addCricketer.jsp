<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Cricketers</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h1>Add Cricketers !</h1>

	<form action="saveCricketer" method="post">

		Player Name : <input type="text" name="playerName" /><br>
		<br> Team Name : <input type="text" name="teamName" /><br>
		<br> Role : <input type="text" name="role" /><br>
		<br> Batting Style : <input type="text" name="battingStyle" /><br>
		<br> Jersey Number : <input type="number" name="jerseyNumber" /><br>
		<br> <input type="submit" value="Save" />

	</form>
</body>
</html>