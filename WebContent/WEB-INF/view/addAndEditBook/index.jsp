<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>The book - Add book</title>
	<link rel="icon" href="https://img.icons8.com/cute-clipart/344/book.png" type="image/gif" sizes="16x16">
	<link href="/WebContent/static/css/main.css" rel="stylesheet" type="text/css">
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
	<div class="container">
		<h1 class="text-title">a book</h1>

		<form class="form" action="<%=request.getContextPath()%>/addBook" method="POST">
			<input type="hidden" name="id" class="input-item" value="0">
			<div class="form-group">
				<label class="text-label" for="book-name">Book name</label>
				<input type="text" name="name" class="input-item ${error == null ? "" : "error"}" placeholder="${error == null ? "Enter the book's name " : error}">
			</div>
			<div class="form-group">
				<label class="text-label" for="author">Author</label>
				<input type="text" name="author" class="input-item" placeholder="Enter the book's author">
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