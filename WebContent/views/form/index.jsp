<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="servletTutorial.entities.Book"%>
<%@ page import="servletTutorial.contants.ServletCommandNames"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<title>The book - Add book</title>
	<link rel="icon" href="./static/image/book.png" type="image/gif" sizes="16x16">
	<link href="./static/css/main.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500" rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
</head>
<body>
	<%
		Book book = (Book) request.getAttribute("bookEdit");
			List<String> errors = (List) request.getAttribute("errors");
	%>
	<div class="container">
		<h1 class="text-title"><%=(( book == null ) ? "Add a new book" : "Edit a book")%></h1>
		<form class="form" action="<%=request.getContextPath()%>/<%=(( book == null ) ? ServletCommandNames.URL_ADD : ServletCommandNames.URL_EDIT)%>" method="POST">
			<input type="hidden" name="id" class="input-item" value="<%= (( book == null ) ? "" : book.getBookId()) %>">
			<div class="form-group">
				<label class="text-label" for="book-name">Book name</label>
				<input type="text" name="name" class="input-item <%= (( errors == null ) ? "" : "error") %>" placeholder="<%= (( errors == null ) ? "Enter the book's name" : errors) %>" value="<%= (( book == null ) ? "" : book.getBookName()) %>">
			</div>
			<div class="form-group">
				<label class="text-label" for="author">Author</label>
				<input type="text" name="author" class="input-item" placeholder="Enter the book's author" value="<%= (( book == null ) ? "" : book.getAuthor()) %>">
			</div>
			<div class="footer-items">
				<button type="submit" class="buton-save">Save</button>
				<a href="books">
					<button type="button" class="button-cancel">Cancel</button>
				</a>
			</div>
		</form>
	</div>
</body>
</html>