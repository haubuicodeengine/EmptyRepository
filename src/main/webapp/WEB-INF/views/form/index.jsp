<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>The book</title>
	<link rel="icon" href="./static/image/book.png" type="image/gif" sizes="16x16">
	<link href="./static/css/main.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500" rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
</head>
<body>
	<div class="container">
		<h1 class="text-title">${bookEdit == null ? "Add " : "Edit "}a book</h1>
		<form class="form" action="<%=request.getContextPath()%>${url}" method="POST">
			<input type="hidden" name="bookId" class="input-item" value="${bookEdit == null ? 0 : bookEdit.getBookId()}">
			<div class="form-group">
				<label class="text-label" for="book-name">Book name</label> 
				<input type="text" name="bookName" value="${bookEdit == null ? "" : bookEdit.getBookName()}" class="input-item ${errors == null ? "" : "error"}" placeholder="${errors == null ? " Enter the book's name " : errors}">
			</div>
			<div class="form-group">
				<label class="text-label" for="author">Author</label> 
				<select class="input-item" name="author.authorId">
					<option value="0" ${bookEdit.getAuthor().getAuthorId() == null ? 'selected="selected"' : ''}>None</option>
					<c:forEach var="author" items="${listAuthor}">
						<option value="${author.getAuthorId()}" ${bookEdit.getAuthor().getAuthorId() == author.getAuthorId() ? 'selected="selected"' : ''}>${author.getAuthorName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label class="text-label" for="author">BookType</label>
				<button class="book-type-dropdown">
					<span class="dropdown-text">Items Select</span>
					<p class="caret"></p>
				</button>
				<ul class="book-type-list d-none">
					<c:forEach var="bookType" items="${listBookType}">
						<li class="multiselect-item multiselect-all book-type-list-item">
							<input type="checkbox" value="${bookType.getBookTypeId()}" name="bookTypeSelected" ${listBookTypeSelected.contains(bookType.getBookTypeId()) ? 'checked' : ''}/>
							<strong>${bookType.getBookTypeName()}</strong>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="footer-items">
				<button type="submit" class="buton-save">Save</button>
				<a href="<%=request.getContextPath()%>/books">
					<button type="button" class="button-cancel">Cancel</button>
				</a>
			</div>
		</form>
	</div>
	<script src="./static/jquery/jquery-3.4.1.js"></script>
	<script>
	$(document).ready(function(){
		$(".book-type-dropdown").click(function(e){
			e.preventDefault();
			$(".book-type-list").toggle();
		});
	});
	</script>
</body>
</html>