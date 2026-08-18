<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Management System</title>

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

.table th {
	text-align: center;
}

.table td {
	vertical-align: middle;
	text-align: center;
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
				class="card-header bg-primary text-white d-flex justify-content-between align-items-center">

				<h3 class="mb-0">Library Book Management</h3>

				<div>

					<a href="<c:url value='/book/add'/>" class="btn btn-light btn-sm">
						+ Add Book </a> <a href="<c:url value='/book/trash'/>"
						class="btn btn-warning btn-sm"> 🗑 Trash </a>

				</div>

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

						<div class="alert alert-info text-center">No Books
							Available.</div>

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
									<th>Status</th>
									<th width="170">Action</th>

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

										<td><c:choose>

												<c:when test="${book.stockQuantity>0}">

													<span class="badge bg-success"> In Stock </span>

												</c:when>

												<c:otherwise>

													<span class="badge bg-danger"> Out of Stock </span>

												</c:otherwise>

											</c:choose></td>

										<td><a href="<c:url value='/book/edit/${book.id}'/>"
											class="btn btn-warning btn-sm action-btn"> Edit </a> <a
											href="<c:url value='/book/delete/${book.id}'/>"
											class="btn btn-danger btn-sm"
											onclick="return confirm('Move this book to Trash?');">

												Delete </a></td>

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