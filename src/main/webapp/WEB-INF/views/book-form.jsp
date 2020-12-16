<%@ include file="/common/configLanguage.jsp"%>
<%@ include file="/common/taglib.jsp"%>
<%@ include file="/common/import.jsp"%>
	<%
		BookDto book = (BookDto) request.getAttribute("book");
		String url = "/insert";
		Map<String, String> errors = (Map) request.getAttribute("errors");

		if (book != null) {

			if(book.getBookId() != null){

				url = "/update";
			}
		}
	%>
	<div class="container-fluid">
		<div class="row body-content">
			<div class="col-sm-2"></div>

			<div class="col-sm-6">
				<form action="<%=request.getContextPath() + url%>" method="POST">
					<div class="row form-title">
						<h2 class="form-text-title">Create New Book</h2>
					</div>

					<input type="hidden" name="bookId"
						value="${ book == null ? '' : book.getBookId()}">

					<div class="form-group row form-content">
						<label for="bookName" class="col-sm-3 col-form-label">Book Name : </label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="bookName"
								value="${book == null ? '' : book.getBookName()}" placeholder="Enter name of the book here">
								<p class="error">${ errors == null ? '' : errors.get("bookName")}</p>
						</div>
					</div>

					<div class="form-group row form-content">
						<label for="bookAuthor" class="col-sm-3 col-form-label">Book Author : </label>
						<div class="col-sm-9">
							<select class="form-control" name="bookAuthor.id">
								<c:forEach items="${authors}" var="author">
									<option value="${author.getId()}">${author.getName()}</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="form-group row form-content">
						<label for="bookAuthor" class="col-sm-3 col-form-label">Book Type : </label>
						<div class="col-sm-9">
							<c:forEach items="${bookTypes}" var="bookType">
								<input type="checkbox" name="typeId" value="${bookType.getId()}"
								${currentTypes.contains(bookType.getId()) ? 'checked' : '' }>
										<p>${bookType.getName()}</p>
							</c:forEach>
							<p class="error">${ errors == null ? '' : errors.get("bookType")}</p>
						</div>
						
					</div>

					<button type="submit" class="btn btn-primary">Done</button>

				</form>
			</div>

			<div class="col-sm-2"></div>
		</div>
	</div>
