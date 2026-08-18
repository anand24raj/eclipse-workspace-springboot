<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Employee Skill Registration</title>
</head>
<body>

<h2>Employee Skill Registration</h2>

<form action="${pageContext.request.contextPath}/employee/save" method="post">

    Employee Name:
    <input type="text" name="employeeName" required>
    <br><br>

    Skill Name:
    <input type="text" name="skillName" required>
    <br><br>

    Experience:
    <input type="number" name="experience" required>
    <br><br>

    Project Name:
    <input type="text" name="projectName" required>
    <br><br>

    <input type="submit" value="Save">
    <input type="reset" value="Reset">

</form>

</body>
</html>