<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>The book</title>
	
	<link rel="icon" href="https://img.icons8.com/cute-clipart/344/book.png" type="image/gif" sizes="16x16">
	<link href=../static/css/main.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500" rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
	
	<style>
		body {
			margin: 0;
			font-size: 16px;
			font-weight: normal;
			direction: ltr;
			font-family: "Google Sans Display",Arial,Helvetica,sans-serif;
		}
		
		*, inpput {
			font-family: "Google Sans Display",Arial,Helvetica,sans-serif;
		}
		
		button:focus {
		    outline: none !important;
		    border:1px solid #ddd;
		    box-shadow: 0 0 10px #ddd;
		}
		
		a {
			cursor: pointer;	
		}
		
		.red {
			color: #df013a;
		}
		
		.blue {
			color: blue;
		}
		
		.error::-webkit-input-placeholder {
		    color: #df013a;
		    font-weight: bold;
		 }
		
		.label-error {
			border: 1px solid #df013a; 
		}
		
		.text-title {
			text-align: center;
		}
		
		.form {
			width: 70%;
			margin: 0 auto;
		}
		
		.form-group {
			position: relative;
		}
		
		.text-label {
			position: absolute;
		    background-color: #fff;
		    left: 7px;
		    top: 0;
		    padding: 0 5px;
		}
		
		.form label {
			font-weight: bold;
		}
		
		.input-item {
		    width: 100%;
		    border: 1px solid #ddd;
		    padding: 12px 15px;
		    border-radius: 5px;
		    font-size: 16px;
		    margin: 10px 0;
		    box-sizing: border-box;
		}
		
		.input-item:focus {
		    outline: none !important;
		    border:1px solid grey;
		    box-shadow: 0 0 10px #ddd;
		}
		
		.input-item::-webkit-input-placeholder {
			font-family: arial,tahoma,sans-serif;
			font-size: 16px;
		}
		
		.buton-save {
			background: #088a29;
		    border-radius: 5px;
		    border: 1px solid #ddd;
		    padding: 12px 30px;
		    color: #fff;
		    margin-right: 15px;
		    font-size: 16px;
		    cursor: pointer;
		}
		
		.button-cancel {
			background: #f4fa58;
		    border-radius: 5px;
		    border: 1px solid #ddd;
		    padding: 12px 24px;
		    color: #000;
		    font-size: 16px;
		    cursor: pointer;
		}	
		
		.footer-items {
			display: flex;
		    justify-content: center;
		    margin-top: 20px;
		}
		
		.container {
		    width: 70%;
		    margin: 0 auto;
		}
		
		.table-list {
		    border-collapse: collapse;
		    text-align: center;
		    width: 100%;
		    border-radius: 5px;
		 	overflow: hidden;
		}
		
		.table-list, .book-item {
			border: 1px solid #ddd;
		}
		
		.list-books {
			background: #fafafa;
		}
		.book-title-item {
			padding: 10px;
			background: #151515;
		    color: #fff;
		}
		
		.book-item {
			height: 40px;
		}
		
		.header-modal {
			width: 100%;
		}
		
		.icon-confirm {
			width: 150px;
			height: 150px;
			display: block;
		  	margin-left: auto;
		  	margin-right: auto;
		}
		
		.modal-body {
			margin: 0 auto;
		}
		
		.modal-body button {
			padding: 5px 50px;
		}
		
		.heading {
			margin: 25px 0;
		}
		
		.btn-add {
			display: flex;
		}
		
		.btn-add:hover {
			text-decoration: none;
		}
		
		.book-actions {
			display: flex;
		    justify-content: flex-end;
		}
		
		.close {
			position: absolute;
		    right: 13px;
		    top: 10px;
		}
		
		.btn-add span {
			background: #088a29;
		    border-radius: 5px;
		    border: 1px solid #ddd;
		    padding: 10px 20px;
		    margin-bottom: 10px;
		    color: #fff;
		}
		
		.error {
			border: 1px solid #df013a;
		}	
	</style>
</head>
<body>
	<h1 class="text-center heading">The Book</h1>
	<div class="container">
		<div class="book-actions">
			<a href="addBook" class="btn-add">
				<span>Add new a book</span>
			</a>
		</div>
		<table class="table-list">
			<tr class="book-title">
				<th class="book-title-item">No.</th>
				<th class="book-title-item">Book name</th>
				<th class="book-title-item">Author name</th>
				<th class="book-title-item">Price</th>
				<th class="book-title-item">Quantity</th>
				<th class="book-title-item">Actions</th>
			</tr>
			<tbody class="list-books">
			<c:forEach var="book" items="${listBooks}">
				<tr class="book-item">
					<td class="book-item-description">${book.getBookId()}</td>
					<td class="book-item-description">${book.getBookName()}</td>
					<td class="book-item-description">${book.getAuthor()}</td>
					<td class="book-item-description">${book.getPrice()}</td>
					<td class="book-item-description">${book.getQuantity()}</td>
					<td class="book-item-description">
						<i onclick="confirmation('deleteBook?id=${book.getBookId()}', 'delete')" class="fas fa-trash red" data-toggle="modal" data-target="#myModal"></i>&emsp;
						<a href="editBook?id=${book.getBookId()}"><i class="fas fa-pen blue"></i></a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>