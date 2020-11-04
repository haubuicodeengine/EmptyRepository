<%@ include file="../common/import.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../static/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="../static/css/Style.css" rel="stylesheet" type="text/css">
<title>Book management - Home</title>
</head>
<body>
	<div class="container-fluid">
		<div class="header">
			<h2 style="margin:5px">Book Management Application</h2>
		</div>
		<div class="row body-content">
			<div class="col-sm-2 left-bar"></div>
			<div class="col-sm-8 middle">
				<table class="table table-striped table-hover">
					<thead>
						<tr class="table-title">
							<th colspan="5">List Of Books</th>
						</tr>
						<tr class="table-col-title">
							<th scope="col">Book ID</th>
							<th scope="col">Book Name</th>
							<th scope="col">Book Author</th>
							<th scope="col">Book Type</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test = "${listBooks == null || listBooks.size() == 0}">
								<th colspan="5">No Data</th>
							</c:when>
							<c:otherwise>
								<c:forEach items="${listBooks}" var="book" varStatus="status">
									<tr>
										<td>${book.getBookId()}</td>
										<td>${book.getBookName()}</td>
										<td>${book.getBookAuthor().getAuthorName()}</td>
										<td>
											<c:forEach items="${listBookAndType}" var="bookAndType" varStatus="status">
												${bookAndType.getBook().getBookId() ==  book.getBookId() ? bookAndType.getBookType().getBookTypeName() : ''}
											</c:forEach>
										</td>
										<td>
											<a href="./edit?bookId=${book.getBookId()}"><button class="btn btn-success">Edit</button></a>
											<a href="./delete?bookId=${book.getBookId()}"><button class="btn btn-danger">Delete</button></a>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
					      </c:choose>
					</tbody>
				</table>
				<a href="./add">
					<button class="btn btn-primary">Add New Book</button>
				</a>
			</div>
			<div class="col-sm-2 right-bar"></div>
		</div>
	</div>
	<script src="../static/vendor/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>