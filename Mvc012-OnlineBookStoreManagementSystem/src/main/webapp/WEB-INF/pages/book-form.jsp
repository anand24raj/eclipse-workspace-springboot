<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>

<title><c:choose>
		<c:when test="${book.id == null}">
                Add Book
            </c:when>
		<c:otherwise>
                Edit Book
            </c:otherwise>
	</c:choose></title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>

	<div class="book-container">

		<div class="book-card">

			<div class="book-card-header">
				<h3>
					<c:choose>
						<c:when test="${book.id == null}">
                        Add New Book
                    </c:when>
						<c:otherwise>
                        Edit Book
                    </c:otherwise>
					</c:choose>
				</h3>
			</div>

			<div class="book-card-body">
				<c:choose>

					<c:when test="${book.id == null}">
						<c:set var="formAction"
							value="${pageContext.request.contextPath}/book/save" />
					</c:when>

					<c:otherwise>
						<c:set var="formAction"
							value="${pageContext.request.contextPath}/book/update" />
					</c:otherwise>

				</c:choose>

				<form:form action="${formAction}" method="post"
					modelAttribute="book">

					<form:hidden path="id" />

					<div class="mb-3">

						<label class="form-label"> Book Title </label>

						<form:input path="title" cssClass="form-control" />

						<form:errors path="title" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Author Name </label>

						<form:input path="author" cssClass="form-control" />

						<form:errors path="author" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Category </label>

						<form:input path="category" cssClass="form-control" />

						<form:errors path="category" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Price </label>

						<form:input path="price" type="number" step="0.01"
							cssClass="form-control" />

						<form:errors path="price" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Publisher </label>

						<form:input path="publisher" cssClass="form-control" />

						<form:errors path="publisher" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Published Date </label>

						<form:input path="publishedDate" type="date"
							cssClass="form-control" />

						<form:errors path="publishedDate" cssClass="text-danger" />

					</div>


					<div class="mb-3">

						<label class="form-label"> Stock Quantity </label>

						<form:input path="stockQuantity" type="number"
							cssClass="form-control" />

						<form:errors path="stockQuantity" cssClass="text-danger" />

					</div>


					<button type="submit" class="btn btn-success">

						<c:choose>
							<c:when test="${book.id == null}">
                            Save Book
                        </c:when>
							<c:otherwise>
                            Update Book
                        </c:otherwise>
						</c:choose>

					</button>

					<a href="${pageContext.request.contextPath}/book/list"
						class="btn btn-secondary"> Cancel </a>

				</form:form>

			</div>

		</div>

	</div>

</body>
</html>