package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;
import com.codeenginestudio.bookManagement.models.Book;
import com.codeenginestudio.bookManagement.util.BookUtil;
import com.codeenginestudio.bookManagement.validator.BookValidator;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookUtil._displayView(request, response, "/view/AddOrEditBook.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		List<Map<String, String>> bookInputErrors = BookValidator._validate(bookName);

		if (!bookInputErrors.get(0).isEmpty()) {

			Book inValid = new Book(bookName, bookAuthor);
			request.setAttribute("book", inValid);
			request.setAttribute("bookErr", bookInputErrors);
			BookUtil._displayView(request, response, "/view/AddOrEditBook.jsp");

		} else {

			ManageBook.addNewBook(bookName, bookAuthor);
			request.setAttribute("listBooks", ManageBook.getListBooks());
			BookUtil._displayView(request, response, "/view/Home.jsp");
		}
	}

	private static final long serialVersionUID = 1L;
}
