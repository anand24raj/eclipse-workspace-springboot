<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${formTitle}</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background: #f4f6f9;
}

.container {
	max-width: 850px;
	margin-top: 40px;
}

.card {
	border-radius: 15px;
}

.required {
	color: red;
}

.error {
	color: red;
	font-size: 14px;
}
</style>

</head>

<body>

	<div class="container">

		<div class="card shadow">

			<div class="card-header bg-primary text-white">

				<h3>${formTitle}</h3>

			</div>

			<div class="card-body">

				<form:form modelAttribute="book" method="post"
					action="${formAction}">

					<c:if test="${not empty book.id}">
						<form:hidden path="id" />
					</c:if>

					<div class="row">

						<div class="col-md-6 mb-3">

							<label class="form-label"> Book Title <span
								class="required">*</span>

							</label>

							<form:input path="title" cssClass="form-control"
								placeholder="Enter Book Title" />

							<form:errors path="title" cssClass="error" />

						</div>

						<div class="col-md-6 mb-3">

							<label class="form-label"> Author <span class="required">*</span>

							</label>

							<form:input path="author" cssClass="form-control"
								placeholder="Enter Author" />

							<form:errors path="author" cssClass="error" />

						</div>

					</div>

					<div class="row">

						<div class="col-md-6 mb-3">

							<label class="form-label"> Category <span
								class="required">*</span>

							</label>

							<form:select path="category" cssClass="form-select">

								<form:option value="">Select Category</form:option>

								<form:option value="Programming">Programming</form:option>

								<form:option value="Science">Science</form:option>

								<form:option value="History">History</form:option>

								<form:option value="Biography">Biography</form:option>

								<form:option value="Business">Business</form:option>

								<form:option value="Education">Education</form:option>

								<form:option value="Fiction">Fiction</form:option>

								<form:option value="Other">Other</form:option>

							</form:select>

							<form:errors path="category" cssClass="error" />

						</div>

						<div class="col-md-6 mb-3">

							<label class="form-label"> Price <span class="required">*</span>

							</label>

							<form:input path="price" type="number" step="0.01" min="1"
								cssClass="form-control" placeholder="Enter Price" />

							<form:errors path="price" cssClass="error" />

						</div>

					</div>

					<div class="row">

						<div class="col-md-6 mb-3">

							<label class="form-label"> Publisher </label>

							<form:input path="publisher" cssClass="form-control"
								placeholder="Publisher Name" />

						</div>

						<div class="col-md-6 mb-3">

							<label class="form-label"> Published Date <span
								class="required">*</span>

							</label>

							<form:input path="publishedDate" type="date"
								cssClass="form-control" />

							<form:errors path="publishedDate" cssClass="error" />

						</div>

					</div>

					<div class="row">

						<div class="col-md-6 mb-3">

							<label class="form-label"> Stock Quantity <span
								class="required">*</span>

							</label>

							<form:input path="stockQuantity" type="number" min="0"
								cssClass="form-control" placeholder="Enter Stock" />

							<form:errors path="stockQuantity" cssClass="error" />

						</div>

					</div>

					<hr>

					<button class="btn btn-success">

						<c:choose>

							<c:when test="${empty book.id}">

Save Book

</c:when>

							<c:otherwise>

Update Book

</c:otherwise>

						</c:choose>

					</button>

					<a href="<c:url value='/book/list'/>" class="btn btn-secondary">

						Cancel </a>

				</form:form>

			</div>

		</div>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>
</html>