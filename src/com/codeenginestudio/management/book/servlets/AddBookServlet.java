package com.codeenginestudio.management.book.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.management.book.models.Book;
import com.codeenginestudio.management.book.repository.BookRepository;
import com.codeenginestudio.management.book.util.BookUtil;
import com.codeenginestudio.management.book.validator.BookValidator;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookUtil.displayView(request, response, "/static/view/book/book-form.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		Book theBook = new Book(bookName, bookAuthor);
		Map<String, String> errors = BookValidator.validate(theBook);

		if (!errors.isEmpty()) {

			request.setAttribute("book", theBook);
			request.setAttribute("errors", errors);
			BookUtil.displayView(request, response, "/static/view/book/book-form.jsp");

		} else {

			BookRepository.addNewBook(theBook);
			response.sendRedirect(request.getContextPath() + "/Book/");
		}
	}

	private static final long serialVersionUID = 1L;
}
