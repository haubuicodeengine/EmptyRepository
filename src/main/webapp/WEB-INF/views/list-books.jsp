
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.codeenginestudio.bookmanagement.dto.BookDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<div class="container-fluid">
		<div class="row body-content">

			<div class="col-sm-2 left-bar"></div>

			<div class="col-sm-8 middle">
				<table class="table table-striped table-hover">
					<thead >
						<tr class="table-title">
							<th colspan="5">List Of Books</th>
						</tr>
						<tr class="table-col-title">
							<th scope="col">Book ID</th>
							<th scope="col">Book Name</th>
							<th scope="col">Book Author</th>
							<th scope="col">Book Type</th>
							<th scope="col">Options</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test = "${listBooks == null || listBooks.size() == 0}">
								<th colspan="5">No Data</th>
							</c:when>
							<c:otherwise>
								<c:forEach items="${listBooks}" var="book" varStatus="status">
									<tr>
										<td>${book.getBookId()}</td>
										<td>${book.getBookName()}</td>
										<td>${book.getBookAuthor().getName()}</td>
										<td>
											<c:forEach items="${listBookAndtype}" var="bookAndType" varStatus="status">
												${bookAndType.getBook().getBookId() ==  book.getBookId() ? bookAndType.getBookType().getName() : ''}
											</c:forEach>
										</td>
										<td>
											<a href="./edit/${book.getBookId()}"><button class="btn btn-success">Edit</button></a>
											<a href="./delete/${book.getBookId()}"><button class="btn btn-danger">Delete</button></a>
										</td>
									</tr>
								</c:forEach>
							</c:otherwise>
					      </c:choose>
					</tbody>
				</table>

				<a href="./add">
					<button class="btn btn-primary">Add New Book</button>
				</a>
			</div>
		
			<div class="col-sm-2 right-bar"></div>
		</div>
	</div>
