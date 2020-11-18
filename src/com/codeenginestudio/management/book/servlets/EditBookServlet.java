package com.codeenginestudio.management.book.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.management.book.models.Book;
import com.codeenginestudio.management.book.repository.BookRepository;
import com.codeenginestudio.management.book.util.BookUtil;
import com.codeenginestudio.management.book.validator.BookValidator;

@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));

		try {
			request.setAttribute("book", BookRepository.getBook(bookId));
			BookUtil.displayView(request, response, "/static/view/book/book-form.jsp");

		} catch (Exception e) {

			request.setAttribute("errors", e.getMessage());
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/static/view/book/error.jsp");
			dispatcher.include(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		Book theBook = new Book(bookId, bookName, bookAuthor);

		Map<String, String> errors = BookValidator.validate(theBook);

		if (!errors.isEmpty()) {

			request.setAttribute("book", new Book(bookId, bookName, bookAuthor));
			request.setAttribute("errors", errors);
			BookUtil.displayView(request, response, "/static/view/book/book-form.jsp");
		} else {

			try {
				BookRepository.editBook(theBook);
			} catch (Exception e) {
				e.printStackTrace();
			}

			response.sendRedirect(request.getContextPath() + "/Book/");
		}
	}

	private static final long serialVersionUID = 1L;
}
