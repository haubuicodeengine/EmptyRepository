package com.codeenginestudio.bookManagement.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.dao.AuthorDao;
import com.codeenginestudio.bookManagement.dao.BookAndBookTypeDao;
import com.codeenginestudio.bookManagement.dao.BookDao;
import com.codeenginestudio.bookManagement.dao.BookTypeDao;
import com.codeenginestudio.bookManagement.model.Author;
import com.codeenginestudio.bookManagement.model.Book;
import com.codeenginestudio.bookManagement.model.BookAndBookType;
import com.codeenginestudio.bookManagement.util.GeneralUtil;
import com.codeenginestudio.bookManagement.validator.BookValidator;

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
		int authorId = Integer.parseInt(request.getParameter("bookAuthorId"));
		Author bookAuthor = authorDao.getOneAuthor(authorId);

		if (BookValidator._checkEmptyValue(bookName)) {

			request.setAttribute("book", new Book(bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
			GeneralUtil._displayView(request, response, "/view/AddOrEditBook.jsp");

		} else {

			Book newBook = new Book(bookName, bookAuthor);
			bookDao.saveBook(newBook);
			bookAndBookTypeDao.insertListOfBookAndBookType(bookTypeIds, newBook);
			listBook(request, response);
		}
	}

	private void listBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listBooks", bookDao.getAllBook());
		request.setAttribute("listBookAndType", bookAndBookTypeDao.getAllBookAndBookType());
		GeneralUtil._displayView(request, response, "/view/Home.jsp");
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] bookTypeIds = request.getParameterValues("bookTypeId");
		List<String> newListIdTypes = Arrays.asList(bookTypeIds);
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int authorId = Integer.parseInt(request.getParameter("bookAuthorId"));
		String bookName = request.getParameter("bookName");
		Author bookAuthor = authorDao.getOneAuthor(authorId);

		if (BookValidator._checkEmptyValue(bookName)) {

			request.setAttribute("book", new Book(bookId, bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("bookTypes", bookAndBookTypeDao.getAllBookAndBookType());
			GeneralUtil._displayView(request, response, "/view/AddOrEditBook.jsp");

		} else {

			List<String> currentTypes = bookTypeDao.getListIdOfTypeByBookId(bookId);
			Book book = bookDao.getOneBook(bookId);
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			bookDao.updateBook(book);
			bookAndBookTypeDao.updateBookAndBookTypeByBookId(newListIdTypes, currentTypes, book);
			listBook(request, response);
		}
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		request.setAttribute("book", bookDao.getOneBook(bookId));
		request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
		request.setAttribute("authors", authorDao.getAllAuthor());
		GeneralUtil._displayView(request, response, "/view/AddOrEditBook.jsp");
	}

	private void deleteBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		bookAndBookTypeDao.deleteAllBookAndBookTypeByBookId(bookId);
		bookDao.deleteBook(bookId);
		listBook(request, response);
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("bookTypes", bookTypeDao.getAllBookType());
		request.setAttribute("authors", authorDao.getAllAuthor());
		GeneralUtil._displayView(request, response, "/view/AddOrEditBook.jsp");
	}
}
