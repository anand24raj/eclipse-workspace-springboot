<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Electricity Bill Calculator</title>
</head>
<body>

<h2>Electricity Bill Calculator</h2>

<form action="calculateBill" method="post">

	Customer Name:
	<input type="text" name="customerName">
	<br><br>

	Units Consumed:
	<input type="number" name="units">
	<br><br>

	<input type="submit" value="Calculate Bill">

</form>

</body>
</html>