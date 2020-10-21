<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>The book - Add book</title>
	<link rel="icon" href="https://img.icons8.com/cute-clipart/344/book.png" type="image/gif" sizes="16x16">
	<link href="WEB-INF/static/css/main.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500" rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
</head>
<body>
	<div class="container">
		<h1 class="text-title">${bookEdit == null ? "Add" : "Edit"} a book</h1>

		<form class="form" action="<%=request.getContextPath()%>/${bookEdit == null ? "addBook" : "editBook"}" method="POST">
			<input type="hidden" name="id" class="input-item" value="${bookEdit == null ? 0 : bookEdit.getBookId()}">
			<div class="form-group">
				<label class="text-label" for="book-name">Book name</label>
				<input type="text" name="name" value="${bookEdit == null ? "" : bookEdit.getBookName()}" class="input-item ${error == null ? "" : "error"}" placeholder="${error == null ? "Enter the book's name " : error}">
			</div>
			<div class="form-group">
				<label class="text-label" for="author">Author</label>
				<select class="input-item" name="author.authorId">
					<option value="0" ${bookEdit.getAuthor().getAuthorId() == null ? 'selected="selected"' : ''}>None</option>
					<c:forEach var="author" items="${listAuthors}">
						<option value="${author.getAuthorId()}" ${bookEdit.getAuthor().getAuthorId() == author.getAuthorId() ? 'selected="selected"' : ''}>${author.getAuthorName()}</option>
					</c:forEach>
				</select>
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