<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>The book</title>
	<link rel="icon" href="./static/image/book.png" type="image/gif" sizes="16x16">
	<link type="text/css" href="./static/css/main.css" rel="stylesheet">
	<link rel="stylesheet" href="./static/bootstrap/bootstrap-4.5.3-dist/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500" rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
</head>
<body>
	<h1 class="text-center heading">The Book</h1>
	<div class="container">
		<div class="book-actions">
			<a href="addBook" class="btn-add"> <span>Add new a book</span>
			</a>
		</div>
		<table class="table-list">
			<tr class="book-title">
				<th class="book-title-item">No.</th>
				<th class="book-title-item">Book name</th>
				<th class="book-title-item">Author name</th>
				<th class="book-title-item">Actions</th>
			</tr>
			<tbody class="list-books">
				<c:forEach var="book" items="${listBook}" varStatus="status">
					<tr class="book-item">
						<td class="book-item-description">${status.index + 1}</td>
						<td class="book-item-description">${book.getBookName()}</td>
						<td class="book-item-description">${book.getAuthor().getAuthorName()}</td>
						<td class="book-item-description">
							<i onclick="confirmation('deleteBook?bookId=${book.getBookId()}', 'delete')"
							class="fas fa-trash red" data-toggle="modal" data-target="#myModal"></i>&emsp; 
							<a href="editBook?bookId=${book.getBookId()}">
								<i class="fas fa-pen blue"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="header-modal">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<img class="icon-confirm" alt="confirm-icon" src="./static/image/background-delete-modal.jpg">
						<h5 id="content-confirm-title" class="text-title"></h5>
					</div>
					<div class="modal-body">
						<a id="button-confirm">
							<button type="button" class="btn btn-primary">Confirm</button>
						</a>
						<button type="button" class="btn btn-warning" data-dismiss="modal">Cancel</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="./static/jquery/jquery.min.js"></script>
	<script src="./static/jquery/popper.min.js"></script>
	<script src="./static/bootstrap/bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
	<script src="./static/font-icon/a076d05399.js"></script>
	<script type="text/javascript">
		function confirmation(href, action) {
			$('#button-confirm').attr("href", href);
			$('#content-confirm-title').html('Are you sure you want to ' + action + ' this book ?');
		}
	</script>
</body>
</html>