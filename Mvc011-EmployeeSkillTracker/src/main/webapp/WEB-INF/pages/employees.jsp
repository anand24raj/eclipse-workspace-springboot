<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Employees</title>
</head>
<body>

<h2>All Registered Employees</h2>

<table border="1">
    <tr>
        <th>Employee ID</th>
        <th>Employee Name</th>
        <th>Skill Name</th>
        <th>Experience</th>
        <th>Project Name</th>
    </tr>

    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.employeeName}</td>
            <td>${emp.skillName}</td>
            <td>${emp.experience}</td>
            <td>${emp.projectName}</td>
        </tr>
    </c:forEach>

</table>

<br>

<a href="/employee/register">Add New Employee</a>

</body>
</html>