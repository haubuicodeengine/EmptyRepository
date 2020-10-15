<%@ page import="com.codeenginestudio.bookManagement.models.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Add or Edit Book</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</head>
<style>
.header {
	background-color: #585858e0;
	padding: 30px 40px;
	color: white;
	text-align: center;
	font-weight: bold;
}

.body-content{
	display: flex;
	justify-content: space-around;
	padding: 30px 40px; 
}

.title{
	background-color: #bdeb99;
	justify-content: center;
	margin: 10px 0px;
	border-top-right-radius: 13px;
	border-top-left-radius: 13px;
}

.form-content{
	padding: 0px 10px;
}

.title-text{
	margin:5px;
}
</style>
<body>
	<%
		Book book = (Book) request.getAttribute("book");
		String url = (String) request.getAttribute("url");
		String bookNameErr = (String) request.getAttribute("bookNameErr");

		if (url == null) {
			url = "./Book/AddBook";
		}

		if (bookNameErr == null) {
			bookNameErr = "";
		}
	%>
	<div class="container-fluid">
		<div class="header">
			<h2 style="margin:5px">Book Management Application</h2>
		</div>

		<div class="row body-content">
			<div class="col-sm-2"></div>
			
			<div class="col-sm-6">
				<form action="<%=request.getContextPath() + url%>" method="post">
					<div class="row title">
						<h2 class="title-text">Create New Book</h2>
					</div>

					<input type="hidden" name="bookId"
						value="<%= book == null ? "" : book.getBookId()%>">

					<div class="form-group row form-content">
						<label for="bookName" class="col-sm-3 col-form-label">Book Name : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="bookName"
								value="<%=book == null ? "" : book.getBookName()%>" placeholder="Enter name of the book here">
								<p><%= bookNameErr %></p>
						</div>
					</div>
		
					<div class="form-group row form-content">
						<label for="bookAuthor" class="col-sm-3 col-form-label">Book Author : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="bookAuthor"
								value="<%=book == null ? "" : book.getBookAuthor()%>" placeholder="Enter author of the book here">
						</div>
					</div>

					<button type="submit" class="btn btn-primary">Done</button>

				</form>
			</div>
			
			<div class="col-sm-2"></div>
		</div>
	</div>

</body>
</html>