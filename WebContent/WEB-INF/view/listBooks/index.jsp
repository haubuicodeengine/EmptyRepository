<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="servletTutorial.entities.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Book Management</title>

<link href="./static/css/main.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script></head>
<body>
	<h1 class="text-title">List Books</h1>
	<div class="container">
		<a href="addBook"><button type="button" class="button-add-new">Add new a book</button></a>
		<table class="table-list">
			<tr class="book-title">
				<th class="book-title-item">No.</th>
				<th class="book-title-item">Book Name</th>
				<th class="book-title-item">Author</th>
				<th class="book-title-item">Action</th>
			</tr>
			<tbody class="list-books">
				<%
					int i = 1;
					List<Book> listBooks = (List) request.getAttribute("data");
					if(listBooks != null) {
						for (Book book : listBooks) {
				%>
							<tr class="book-item">
								<td class="book-item-description"><%=book.getBookId()%></td>
								<td class="book-item-description"><%=book.getBookName()%></td>
								<td class="book-item-description"><%=book.getAuthor()%></td>
								<td class="book-item-description">
									<i onclick="confirmation('deleteBook?id=<%=book.getBookId()%>', 'delete')" class="fas fa-trash red" data-toggle="modal" data-target="#myModal"></i>&emsp;
									<a href="editBook?id=<%=book.getBookId()%>"><i class="fas fa-pen blue"></i></a>
								</td>
							</tr>
				<%
						}
					}
				%>
			</tbody>
		</table>
		<div class="modal fade" id="myModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		        <!-- Modal Header -->
		        <div class="header-modal">
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
					<img class="icon-confirm" alt="confirm-icon" src="https://img.freepik.com/free-vector/cute-happy-smiling-intestine-apple-character-flat-cartoon-illustration-icon-design-isolated-white-background-intestine-apple-fruit-character-concept_92289-1502.jpg?size=626&ext=jpg">
		        	<h5 id="content-confirm-title" class="text-title"></h5>
		        </div>
		        
		        <!-- Modal body -->
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
	<script type="text/javascript">
		function confirmation(href, action) {
			$('#button-confirm').attr("href", href);
			$('#content-confirm-title').html('Are you sure you want to ' + action + ' this book ?');
		}
	</script>
	
</body>
</html>