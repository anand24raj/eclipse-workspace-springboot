<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trash Books</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: #f4f6f9;
}

.container {
	margin-top: 40px;
}

.card {
	border-radius: 15px;
}

.table th, .table td {
	text-align: center;
	vertical-align: middle;
}

.action-btn {
	margin-right: 5px;
}
</style>

</head>

<body>

	<div class="container">

		<div class="card shadow">

			<div
				class="card-header bg-dark text-white d-flex justify-content-between align-items-center">

				<h3 class="mb-0">🗑 Trash Books</h3>

				<a href="<c:url value='/book/list'/>" class="btn btn-light"> ←
					Back to Book List </a>

			</div>

			<div class="card-body">

				<c:if test="${not empty successMessage}">
					<div class="alert alert-success">${successMessage}</div>
				</c:if>

				<c:if test="${not empty errorMessage}">
					<div class="alert alert-danger">${errorMessage}</div>
				</c:if>

				<c:choose>

					<c:when test="${empty books}">

						<div class="alert alert-info text-center">No Deleted Books
							Found.</div>

					</c:when>

					<c:otherwise>

						<table class="table table-bordered table-hover">

							<thead class="table-dark">

								<tr>

									<th>ID</th>
									<th>Title</th>
									<th>Author</th>
									<th>Category</th>
									<th>Price</th>
									<th>Publisher</th>
									<th>Published</th>
									<th>Stock</th>
									<th width="220">Action</th>

								</tr>

							</thead>

							<tbody>

								<c:forEach items="${books}" var="book">

									<tr>

										<td>${book.id}</td>

										<td>${book.title}</td>

										<td>${book.author}</td>

										<td>${book.category}</td>

										<td>₹ <fmt:formatNumber value="${book.price}"
												minFractionDigits="2" />

										</td>

										<td>${book.publisher}</td>

										<td>${book.publishedDate}</td>

										<td>${book.stockQuantity}</td>

										<td><a href="<c:url value='/book/restore/${book.id}'/>"
											class="btn btn-success btn-sm action-btn"
											onclick="return confirm('Restore this book?');"> ♻
												Restore </a> <a
											href="<c:url value='/book/permanent-delete/${book.id}'/>"
											class="btn btn-danger btn-sm"
											onclick="return confirm('This book will be permanently deleted. Continue?');">

												❌ Delete </a></td>

									</tr>

								</c:forEach>

							</tbody>

						</table>

					</c:otherwise>

				</c:choose>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>
</html>