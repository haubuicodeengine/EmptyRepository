<%@ include file="../common/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/css/style.css" rel="stylesheet" type="text/css">
<title>Add or Edit Book</title>
</head>
<body>
	<%
		Book book = (Book) request.getAttribute("book");
		String url = "/Book/Add";
		Map<String, String> errors = (Map) request.getAttribute("errors");

		if (book != null) {

			if(book.getBookId() != 0){

				url = "/Book/Edit";
			}
		}
%>
	<div class="container-fluid">
		<div class="header">
			<h2 class="header-title">Book Management Application</h2>
		</div>

		<div class="row body-content">

			<div class="col-sm-2"></div>

			<div class="col-sm-6">

				<form action="<%=request.getContextPath() + url%>" method="post">

					<div class="row form-title">
						<h2 class="form-text-title"><%= url == "/Book/Add" ? "Create New Book" : "Edit Book" %></h2>
					</div>

					<input type="hidden" name="bookId"
						value="<%=book == null ? "" : book.getBookId()%>">

					<div class="form-group row form-content">
						<label for="bookName" class="col-sm-3 col-form-label">Book
							Name : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="bookName"
								value="<%=book == null ? "" : book.getBookName()%>"
								placeholder="Enter name of the book here">
							<p class="error"> <%= errors == null ? "" : errors.get("bookName") %></p>
						</div>
					</div>

					<div class="form-group row form-content">
						<label for="bookAuthor" class="col-sm-3 col-form-label">Book
							Author : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="bookAuthor"
								value="<%=book == null ? "" : book.getBookAuthor()%>"
								placeholder="Enter author of the book here">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Done</button>

				</form>

			</div>

			<div class="col-sm-2"></div>

		</div>

	</div>
	<script src="../static/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>