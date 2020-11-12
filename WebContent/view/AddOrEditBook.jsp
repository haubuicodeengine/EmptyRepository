<%@ include file="../common/import.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../static/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="../static/css/Style.css" rel="stylesheet" type="text/css">
<title>Add or Edit Book</title>
</head>
<body>
	<%
		Book book = (Book) request.getAttribute("book");
		String url = "/Book/Add";
		String bookNameErr = (String) request.getAttribute("bookNameErr");

		if (book != null) {

			url = "/Book/Edit";
		}
	%>
	<div class="container-fluid">

		<div class="header">
			<h2 style="margin: 5px">Book Management Application</h2>
		</div>

		<div class="row body-content">

			<div class="col-sm-2"></div>

			<div class="col-sm-6">

				<form action="<%=request.getContextPath() + url%>" method="post">

					<div class="row form-title">
						<h2 class="form-text-title">Create New Book</h2>
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
							<p class="error"><%=bookNameErr == null ? "" : bookNameErr%></p>
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