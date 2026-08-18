<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill Result</title>
</head>
<body>

<h2>Electricity Bill Details</h2>

Customer Name: ${customerName}
<br><br>

Units Consumed: ${units}
<br><br>

Total Bill: ₹${totalBill}

<a href="./">Calculate Another Bill</a>

</body>
</html>