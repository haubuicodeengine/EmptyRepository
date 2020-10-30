<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>The book</title>
<link rel="icon" href="https://img.icons8.com/cute-clipart/344/book.png"
	type="image/gif" sizes="16x16">
<link href="./static/css/main.css" rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Google+Sans:400,500,700,900|Google+Sans+Display:400,500"
	rel="stylesheet" nonce="fSXOtZ5Ye0RE8N7b_mEygA">
</head>
<body>
	<div class="container">
		<h1 class="text-title">${bookEdit == null ? "Add" : "Edit"}a book</h1>
		<form class="form"
			action="<%=request.getContextPath()%>/${bookEdit == null ? "
			saveAddBook" : "saveEditBook"}" method="POST">
			<input type="hidden" name="bookId" class="input-item"
				value="${bookEdit == null ? "0" :bookEdit.getBookId()}">
			<div class="form-group">
				<label class="text-label" for="book-name">Book name</label> <input
					type="text" name="name" value="${bookEdit == null ? " " :
					bookEdit.getBookName()}" class="input-item ${error == null ? "
					" : "error"}" placeholder="${error == null ? " Enter the book's
					name " :error}">
			</div>
			<div class="form-group">
				<label class="text-label" for="author">Author</label> <select
					class="input-item" name="author.authorId">
					<option value="0"
						${bookEdit.getAuthor().getAuthorId() == null ? 'selected="selected"' : ''}>None</option>
					<c:forEach var="author" items="${listAuthor}">
						<option value="${author.getAuthorId()}"
							${bookEdit.getAuthor().getAuthorId() == author.getAuthorId() ? 'selected="selected"' : ''}>${author.getAuthorName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group" style="margin-top: 10px">
				<label class="text-label" for="author" style="top: -10px;">Book
					Type</label> <select class="input-item" name="bookType.bookTypeId"
					id="data-bookType">
					<c:forEach var="bookType" items="${listBookType}">
						<option value="${bookType.getBookTypeId()}">${bookType.getBookTypeName()}</option>
					</c:forEach>
				</select>
			</div>

			<div class="footer-items" style="margin-top: 200px">
				<button type="submit" class="buton-save">Save</button>
				<a href="books">
					<button type="button" class="button-cancel">Cancel</button>
				</a>
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
	<script>
		$(document).ready(function() {
			$("#data-bookType").CreateMultiCheckBox({
				defaultText : 'Select Below',
			});
		});
		$(document).ready(function() {
			$(document).on("click", ".MultiCheckBox",
				function() {
					var detail = $(this).next();
					detail.show();
				});

			$(document).on("click",".MultiCheckBoxDetailHeader input",
				function(e) {
					e.stopPropagation();
					var hc = $(this).attr("checked");
					$(this).closest(".MultiCheckBoxDetail").find(".MultiCheckBoxDetailBody input").attr("checked", hc);
					$(this).closest(".MultiCheckBoxDetail").next().UpdateSelect();
				});

			$(document).on("click",".MultiCheckBoxDetailHeader",
				function(e) {
					var inp = $(this).find("input");
					var chk = inp.attr("checked");
					inp.attr("checked", !chk);
					$(this).closest(".MultiCheckBoxDetail").find(".MultiCheckBoxDetailBody input").attr("checked", !chk);
					$(this).closest(".MultiCheckBoxDetail").next().UpdateSelect();
				});

			$(document).on("click",".MultiCheckBoxDetail .cont input",
				function(e) {
					e.stopPropagation();
					$(this).closest(".MultiCheckBoxDetail").next().UpdateSelect();

					var val = ($(".MultiCheckBoxDetailBody input:checked").length == $(".MultiCheckBoxDetailBody input").length)
					$(".MultiCheckBoxDetailHeader input").attr("checked", val);
				});

			$(document).on("click",".MultiCheckBoxDetail .cont",
				function(e) {
					var inp = $(this).find("input");
					var chk = inp.attr("checked");
					inp.attr("checked", !chk);

					var multiCheckBoxDetail = $(this).closest(".MultiCheckBoxDetail");
					var multiCheckBoxDetailBody = $(this).closest(".MultiCheckBoxDetailBody");
					multiCheckBoxDetail.next().UpdateSelect();

					var val = ($(".MultiCheckBoxDetailBody input:checked").length == $(".MultiCheckBoxDetailBody input").length)
					$(".MultiCheckBoxDetailHeader input").attr("checked", val);
				});

			$(document).mouseup(
				function(e) {
					var container = $(".MultiCheckBoxDetail");
					if (!container.is(e.target)&& container.has(e.target).length === 0) {
						container.hide();
					}
				});
		});

		var defaultMultiCheckBoxOption = {
			height : '200px'
		};

		jQuery.fn.extend({
			CreateMultiCheckBox : function(options) {

				var localOption = {};
				localOption.width = (options != null
						&& options.width != null && options.width != undefined) ? options.width
						: defaultMultiCheckBoxOption.width;
				localOption.defaultText = (options != null
						&& options.defaultText != null && options.defaultText != undefined) ? options.defaultText
						: defaultMultiCheckBoxOption.defaultText;
				localOption.height = (options != null
						&& options.height != null && options.height != undefined) ? options.height
						: defaultMultiCheckBoxOption.height;

				this.hide();
				this.attr("multiple", "multiple");
				var divSel = $("<div class='MultiCheckBox'>" + localOption.defaultText
					+ "<span class='k-icon k-i-arrow-60-down'><svg aria-hidden='true' focusable='false' data-prefix='fas' data-icon='sort-down' role='img' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 320 512' class='svg-inline--fa fa-sort-down fa-w-10 fa-2x'><path fill='currentColor' d='M41 288h238c21.4 0 32.1 25.9 17 41L177 448c-9.4 9.4-24.6 9.4-33.9 0L24 329c-15.1-15.1-4.4-41 17-41z' class=''></path></svg></span></div>")
					.insertBefore(this);
				divSel.css({
					"width" : localOption.width
				});

				var detail = $(
					"<div class='MultiCheckBoxDetail'><div class='MultiCheckBoxDetailHeader'><input type='checkbox' class='mulinput' value='-1982' /><div>Select All</div></div><div class='MultiCheckBoxDetailBody'></div></div>")
					.insertAfter(divSel);
				detail.css({
					"width" : parseInt(options.width) + 8,
					"max-height" : localOption.height
				});
				var multiCheckBoxDetailBody = detail.find(".MultiCheckBoxDetailBody");

				this.find("option").each(function() {
					var val = $(this).attr("value");
	
					if (val == undefined)
						val = '';
	
					multiCheckBoxDetailBody.append("<div class='cont'><div><input name ='bookTypeSelected' type='checkbox' class='mulinput' value='" + val + "' /></div><div>"
						+ $(this).text()
						+ "</div></div>");
				});

				multiCheckBoxDetailBody.css("max-height",(parseInt($(".MultiCheckBoxDetail").css("max-height")) - 28)+ "px");
			},
			UpdateSelect : function() {
				var arr = [];

				this.prev().find(".mulinput:checked").each(function() {
					arr.push($(this).val());
				});

				this.val(arr);
			},
		});
	</script>
</body>
</html>