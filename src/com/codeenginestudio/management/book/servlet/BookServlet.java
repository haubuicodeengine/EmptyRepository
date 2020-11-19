package com.codeenginestudio.management.book.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.management.book.dao.AuthorDao;
import com.codeenginestudio.management.book.dao.BookAndBookTypeDao;
import com.codeenginestudio.management.book.dao.BookDao;
import com.codeenginestudio.management.book.dao.BookTypeDao;
import com.codeenginestudio.management.book.model.Author;
import com.codeenginestudio.management.book.model.Book;
import com.codeenginestudio.management.book.util.GeneralUtil;
import com.codeenginestudio.management.book.validator.BookValidator;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private BookAndBookTypeDao bookAndBookTypeDao;
	private BookTypeDao bookTypeDao;
	private AuthorDao authorDao;

	public void init() {

		bookDao = new BookDao();
		bookAndBookTypeDao = new BookAndBookTypeDao();
		authorDao = new AuthorDao();
		bookTypeDao = new BookTypeDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/book/add":
			addForm(request, response);
			break;
		case "/book/insert":
			insertBook(request, response);
			break;
		case "/book/delete":
			deleteBook(request, response);
			break;
		case "/book/edit":
			editForm(request, response);
			break;
		case "/book/update":
			updateBook(request, response);
			break;
		case "/book/":
			listBook(request, response);
			break;
		default:
			listBook(request, response);
			break;
		}
	}

	private void insertBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String[] bookTypeIds = request.getParameterValues("bookTypeId");
		Long authorId = Long.parseLong(request.getParameter("bookAuthorId"));
		Author bookAuthor = authorDao.getAuthor(authorId);
		Book theBook = new Book(bookName, bookAuthor);

		Map<String, String> errors = BookValidator.validate(theBook, bookTypeIds);

		if (!errors.isEmpty()) {

			request.setAttribute("book", theBook);
			request.setAttribute("errors", errors);
			request.setAttribute("bookTypes", bookTypeDao.getBookTypes());
			request.setAttribute("authors", authorDao.getAuthors());
			GeneralUtil.displayView(request, response, "/view/book-form.jsp");

		} else {

			bookDao.saveBook(theBook);
			bookAndBookTypeDao.insertListOfBookAndBookType(bookTypeIds, theBook);
			response.sendRedirect(request.getContextPath() + "/book/");
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listBooks", bookDao.getBooks());
		request.setAttribute("listBookAndType", bookAndBookTypeDao.getBookAndBookTypes());
		GeneralUtil.displayView(request, response, "/view/list-book.jsp");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] bookTypeIds = request.getParameterValues("bookTypeId");
		Long bookId = Long.parseLong(request.getParameter("bookId"));
		Long authorId = Long.parseLong(request.getParameter("bookAuthorId"));
		String bookName = request.getParameter("bookName");
		Author bookAuthor = authorDao.getAuthor(authorId);
		Book theBook = new Book(bookId, bookName, bookAuthor);
		List<Long> newListIdTypes = GeneralUtil.convertArrayStringToListLong(bookTypeIds);

		Map<String, String> errors = BookValidator.validate(theBook, bookTypeIds);
		if (!errors.isEmpty()) {

			request.setAttribute("book", theBook);
			request.setAttribute("errors", errors);
			request.setAttribute("bookTypes", bookTypeDao.getBookTypes());
			request.setAttribute("bookAndBookTypes", newListIdTypes);
			request.setAttribute("authors", authorDao.getAuthors());
			GeneralUtil.displayView(request, response, "/view/book-form.jsp");

		} else {

			List<Long> currentTypes = bookTypeDao.getListIdOfTypeByBookId(bookId);
			bookDao.updateBook(theBook);
			bookAndBookTypeDao.updateBookAndBookTypeByBookId(newListIdTypes, currentTypes, theBook);
			response.sendRedirect(request.getContextPath() + "/book/");
		}
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long bookId = Long.parseLong(request.getParameter("bookId"));

		try {
			request.setAttribute("book", bookDao.getBook(bookId));
			request.setAttribute("bookTypes", bookTypeDao.getBookTypes());
			request.setAttribute("bookAndBookTypes", bookTypeDao.getListIdOfTypeByBookId(bookId));
			request.setAttribute("authors", authorDao.getAuthors());
			GeneralUtil.displayView(request, response, "/view/book-form.jsp");

		} catch (Exception e) {

			request.setAttribute("errors", e.getMessage());
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/error.jsp");
			dispatcher.include(request, response);
			e.printStackTrace();
		}
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long bookId = Long.parseLong(request.getParameter("bookId"));
		bookAndBookTypeDao.deleteAllBookAndBookTypeByBookId(bookId);
		bookDao.deleteBook(bookId);
		response.sendRedirect(request.getContextPath() + "/book/");
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("bookTypes", bookTypeDao.getBookTypes());
		request.setAttribute("authors", authorDao.getAuthors());
		GeneralUtil.displayView(request, response, "/view/book-form.jsp");
	}
}
