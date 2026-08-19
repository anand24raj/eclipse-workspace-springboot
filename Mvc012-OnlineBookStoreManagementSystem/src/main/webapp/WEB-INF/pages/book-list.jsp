<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>

<head>

<title>Book Store</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

	<div class="container-fluid mt-4">

		<div class="d-flex justify-content-between align-items-center mb-4">

			<h2>Online Book Store</h2>

			<a href="${pageContext.request.contextPath}/book/new"
				class="btn btn-primary"> + Add New Book </a>

		</div>


		<!-- Search -->

		<form action="${pageContext.request.contextPath}/book/search"
			method="get" class="row g-2 mb-4">

			<div class="col-md-6">

				<input type="text" name="keyword" value="${keyword}"
					class="form-control"
					placeholder="Search by title, author or category">

			</div>

			<div class="col-md-auto">

				<button type="submit" class="btn btn-success">Search</button>

			</div>

			<div class="col-md-auto">

				<a href="${pageContext.request.contextPath}/book/list"
					class="btn btn-secondary"> Clear </a>

			</div>

		</form>


		<!-- Book Table -->

		<div class="book-table-container">

			<table class="table book-table">

				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Category</th>
						<th>Price</th>
						<th>Publisher</th>
						<th>Published Date</th>
						<th>Stock</th>
						<th>Actions</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach var="book" items="${books}">

						<tr>

							<td>${book.id}</td>

							<td class="book-title">${book.title}</td>

							<td>${book.author}</td>

							<td>${book.category}</td>

							<td class="book-price">₹${book.price}</td>

							<td>${book.publisher}</td>

							<td>${book.publishedDate}</td>

							<td>${book.stockQuantity}</td>

							<td>
								<div class="action-buttons">

									<a
										href="${pageContext.request.contextPath}/book/edit/${book.id}"
										class="btn btn-edit"> Edit </a> <a
										href="${pageContext.request.contextPath}/book/delete/${book.id}"
										class="btn btn-delete"
										onclick="return confirm('Are you sure you want to delete this book?');">
										Delete </a>

								</div>
							</td>

						</tr>

					</c:forEach>

				</tbody>

			</table>

		</div>


		<!-- Pagination -->

		<c:if test="${bookPage.totalPages > 0}">

			<nav>

				<ul class="pagination justify-content-center">


					<!-- Previous -->

					<c:choose>

						<c:when test="${bookPage.first}">

							<li class="page-item disabled"><span class="page-link">
									Previous </span></li>

						</c:when>

						<c:otherwise>

							<li class="page-item"><c:choose>

									<c:when test="${not empty keyword}">

										<a class="page-link"
											href="${pageContext.request.contextPath}/book/search?keyword=${keyword}&page=${bookPage.number - 1}">

											Previous </a>

									</c:when>

									<c:otherwise>

										<a class="page-link"
											href="${pageContext.request.contextPath}/book/list?page=${bookPage.number - 1}">

											Previous </a>

									</c:otherwise>

								</c:choose></li>

						</c:otherwise>

					</c:choose>


					<!-- Page Numbers -->

					<c:forEach begin="0" end="${bookPage.totalPages - 1}" var="i">

						<li
							class="page-item
                        ${i == bookPage.number ? 'active' : ''}">

							<c:choose>

								<c:when test="${not empty keyword}">

									<a class="page-link"
										href="${pageContext.request.contextPath}/book/search?keyword=${keyword}&page=${i}">

										${i + 1} </a>

								</c:when>

								<c:otherwise>

									<a class="page-link"
										href="${pageContext.request.contextPath}/book/list?page=${i}">

										${i + 1} </a>

								</c:otherwise>

							</c:choose>

						</li>

					</c:forEach>


					<!-- Next -->

					<c:choose>

						<c:when test="${bookPage.last}">

							<li class="page-item disabled"><span class="page-link">
									Next </span></li>

						</c:when>

						<c:otherwise>

							<li class="page-item"><c:choose>

									<c:when test="${not empty keyword}">

										<a class="page-link"
											href="${pageContext.request.contextPath}/book/search?keyword=${keyword}&page=${bookPage.number + 1}">

											Next </a>

									</c:when>

									<c:otherwise>

										<a class="page-link"
											href="${pageContext.request.contextPath}/book/list?page=${bookPage.number + 1}">

											Next </a>

									</c:otherwise>

								</c:choose></li>

						</c:otherwise>

					</c:choose>

				</ul>

			</nav>

		</c:if>


		<div class="text-center text-muted">Page ${bookPage.number + 1}
			of ${bookPage.totalPages} | Total Books: ${bookPage.totalElements}</div>

	</div>

</body>
</html>