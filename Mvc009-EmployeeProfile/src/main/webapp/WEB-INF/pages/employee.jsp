<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Profile</title>

<style>

body{
	font-family: Arial;
	background:#f2f2f2;
}

.container{
	width:450px;
	margin:60px auto;
	padding:20px;
	background:white;
	border-radius:10px;
	box-shadow:0 0 10px gray;
}

h2{
	text-align:center;
	color:blue;
}

table{
	width:100%;
	border-collapse:collapse;
}

td{
	padding:10px;
	border:1px solid gray;
}

</style>

</head>
<body>

<div class="container">

<h2>Employee Profile</h2>

<table>

<tr>
<td><b>Employee ID</b></td>
<td>${empId}</td>
</tr>

<tr>
<td><b>Employee Name</b></td>
<td>${empName}</td>
</tr>

<tr>
<td><b>Department</b></td>
<td>${department}</td>
</tr>

<tr>
<td><b>Salary</b></td>
<td>₹${salary}</td>
</tr>

</table>

</div>

</body>
</html>