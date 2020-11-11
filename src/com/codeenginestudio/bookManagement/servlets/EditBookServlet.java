package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;
import com.codeenginestudio.bookManagement.models.Book;
import com.codeenginestudio.bookManagement.util.BookUtil;
import com.codeenginestudio.bookManagement.validator.BookValidator;

@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		request.setAttribute("book", ManageBook.getOneBook(bookId));
		BookUtil._displayView(request, response, "/view/AddOrEditBook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");

		if(BookValidator._checkNullValue(bookName)) {

			request.setAttribute("book", new Book(bookId, bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			BookUtil._displayView(request, response, "/view/AddOrEditBook.jsp");
		}else {

			ManageBook.editBook(bookId, bookName, bookAuthor);
			request.setAttribute("listBooks", ManageBook.getListBooks());
			BookUtil._displayView(request, response, "/view/Home.jsp");
		}
	}

	private static final long serialVersionUID = 1L;
}
