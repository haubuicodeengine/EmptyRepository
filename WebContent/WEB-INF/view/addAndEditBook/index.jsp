<%@ page import="servletTutorial.entities.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="./static/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
		Book book = (Book) request.getAttribute("data");
		String error = (String) request.getAttribute("error");
	%>
	<div class="form-container">
		<h1 class="text-title"><%= (( book == null ) ? "Add" : "Edit")%> a book</h1>

		<form class="form" action="<%=request.getContextPath()%>/<%= (( book == null ) ? "addBook" : "editBook")%>" method="POST">
			<input type="hidden" name="id" class="input-item" value="<%= (( book == null ) ? "" : book.getBookId()) %>">
			<label for="book-name">Book Name</label>
			<input type="text" name="name" class="input-item <%= (( error == null ) ? "" : "error") %>" placeholder="<%= (( error == null ) ? "Enter the book's name" : error) %>" value="<%= (( book == null ) ? "" : book.getBookName()) %>">
				<label for="author">Author</label>
				<input type="text" name="author" class="input-item" placeholder="Enter the book's author" value="<%= (( book == null ) ? "" : book.getAuthor()) %>">
			<div class="footer-items">
				<button type="submit" class="buton-save">Save</button>
				<a href="books"><button type="button" class="button-cancel">Cancel</button></a>
			</div>
		</form>
	</div>
</body>
</html>