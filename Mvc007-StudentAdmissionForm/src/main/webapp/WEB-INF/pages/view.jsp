<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Details</title>

<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: linear-gradient(to right, #8EC5FC, #E0C3FC);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.card {
	background: white;
	padding: 30px;
	width: 500px;
	border-radius: 15px;
	text-align: center;
	box-shadow: 0 10px 25px rgba(0, 0, 0, 0.3);
}

h1 {
	color: #ff4081;
}

.info {
	font-size: 22px;
	color: #333;
	background: #f4f4f4;
	padding: 20px;
	border-radius: 10px;
	border-left: 6px solid #4CAF50;
}
</style>

</head>
<body>

	<div class="card">
		<h1>Registration Successful</h1>

		Student ID: ${stdInfo.studentId} 
		<br>
		
		<br> 
		Student Name: ${stdInfo.studentName} 
		<br>
		
		<br> 
		Course: ${stdInfo.course} 
		<br>
		
		<br> 
		Mobile Number: ${stdInfo.mobileNo}

	</div>

</body>
</html>