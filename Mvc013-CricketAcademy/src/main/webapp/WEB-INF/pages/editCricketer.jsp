<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Cricketers</title>
</head>
<body>

<h1 style="color: red;text-align: center;">Edit Cricketers ! </h1>

<form action="../updateCricketer" method="post">

<input type="hidden" name="playerId"
value="${cricketer.playerId}"/>

Player Name

<input type="text"
name="playerName"
value="${cricketer.playerName}"/>

<br><br>

Team Name

<input type="text"
name="teamName"
value="${cricketer.teamName}"/>

<br><br>

Role

<input type="text"
name="role"
value="${cricketer.role}"/>

<br><br>

Batting Style

<input type="text"
name="battingStyle"
value="${cricketer.battingStyle}"/>

<br><br>

Jersey Number

<input type="number"
name="jerseyNumber"
value="${cricketer.jerseyNumber}"/>

<br><br>

<input type="submit"
value="Update"/>

</form>
</body>
</html>