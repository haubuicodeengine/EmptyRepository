<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codeenginestudio.bookManagement.models.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link href="../static/css/Style.css" rel="stylesheet" type="text/css">
<title>Book management - Home</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
					<thead >
						<tr class="table-title">
							<th colspan="4">List Of Books</th>
						</tr>
						<tr class="table-col-title">
							<th scope="col">Book ID</th>
							<th scope="col">Book Name</th>
							<th scope="col">Book Author</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Book> books = (List) request.getAttribute("listBooks");
							for (Book book : books) {
							%>
								<tr>
									<td><%=book.getBookId()%></td>
									<td><%=book.getBookName()%></td>
									<td><%=book.getBookAuthor()%></td>
									<td>
										<a href="./Edit?bookId=<%=book.getBookId()%>"><button class="btn btn-success">Edit</button></a>
										<a href="./Delete?bookId=<%=book.getBookId()%>"><button class="btn btn-danger">Delete</button></a>
									</td>
								</tr>
							<%
							}
						%>
					</tbody>
				</table>

				<a href="./Add">
					<button class="btn btn-primary">Add New Book</button>
				</a>
			</div>
		
			<div class="col-sm-2 right-bar"></div>

		</div>

		
		
	</div>
</body>
</html>