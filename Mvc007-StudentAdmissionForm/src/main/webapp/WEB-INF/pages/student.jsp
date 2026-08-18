<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>

<style>
body{
    margin:0;
    font-family:Arial, Helvetica, sans-serif;
    background:linear-gradient(135deg,#4facfe,#00f2fe);
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}

.container{
    background:white;
    padding:30px;
    border-radius:15px;
    width:400px;
    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

h2{
    text-align:center;
    color:#0077cc;
    margin-bottom:20px;
}

label{
    font-weight:bold;
    color:#333;
}

input[type=text],
input[type=number]{
    width:100%;
    padding:10px;
    margin:8px 0 18px;
    border:2px solid #4facfe;
    border-radius:8px;
    box-sizing:border-box;
}

input[type=submit]{
    width:100%;
    padding:12px;
    background:linear-gradient(90deg,#ff512f,#dd2476);
    color:white;
    border:none;
    border-radius:8px;
    font-size:18px;
    cursor:pointer;
}

input[type=submit]:hover{
    background:linear-gradient(90deg,#36d1dc,#5b86e5);
}
</style>

</head>
<body>

<div class="container">
<h2>🎓 Student Registration</h2>

<form action="post" method="post">

	<label>Student ID</label>
	<input type="number" name="studentId">

	<label>Student Name</label>
	<input type="text" name="studentName">

	<label>Course</label>
	<input type="text" name="course">

	<label>Mobile Number</label>
	<input type="text" name="mobileNo">

	<input type="submit" value="Register">

</form>

</div>

</body>
</html>