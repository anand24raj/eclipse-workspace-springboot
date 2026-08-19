<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Error</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container mt-5">

		<div class="alert alert-danger">${errorMessage}</div>

		<a href="${pageContext.request.contextPath}/book/list"
			class="btn btn-primary"> Back to Book List </a>

	</div>

</body>
</html>