<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Festival Pass Booking</title>
</head>

<body>

<h2>Film Festival Pass Booking Form</h2>

<form action="festival" method="post">

    Pass ID:
    <input type="number" name="passId"><br><br>

    Visitor Name:
    <input type="text" name="visitorName"><br><br>

    Nationality:
    <input type="text" name="nationality"><br><br>

    Festival Category:
    <input type="text" name="festivalCategory"><br><br>

    Pass Type:
    <input type="text" name="passType"><br><br>

    Visiting Days:
    <input type="number" name="visitingDays"><br><br>

    Email:
    <input type="email" name="email"><br><br>

    <input type="submit" value="Book Pass">

</form>

</body>
</html>