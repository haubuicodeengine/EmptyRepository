package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hibernate.validation.BookValidator;
import hibernate.constants.HibernateCommandNames;
import hibernate.dao.AuthorDao;
import hibernate.dao.BookDao;
import hibernate.dao.BookTypeDao;
import hibernate.dao.Book_BookTypeDao;
import hibernate.entities.Author;
import hibernate.entities.Book;
import hibernate.entities.BookType;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private AuthorDao authorDao;
	private BookTypeDao bookTypeDao;
	private Book_BookTypeDao book_bookTypeDao;

	public EditBookServlet() {
		super();
	}

	public void init() {
		bookDao = new BookDao();
		authorDao = new AuthorDao();
		bookTypeDao = new BookTypeDao();
		book_bookTypeDao = new Book_BookTypeDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));

		Book bookEdit = null;
		try {
			bookEdit = bookDao.getBookById(bookId);

			request.setAttribute("bookEdit", bookEdit);
			_getFile(request, response);
		} catch (Exception e) {
			logger.error("Sorry, something wrong!", e);
			response.sendRedirect(request.getContextPath() + HibernateCommandNames.URL_ERROR);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		int authorId = Integer.parseInt(request.getParameter("author.authorId"));
		String[] listbookType = request.getParameterValues("bookTypeSelected");
		List<String> errors = BookValidator.validate(bookId, bookName, bookDao.getBooks());

		if (errors.size() > 0) {
			request.setAttribute("errors", errors);
			_getFile(request, response);
		} else {
			Book book = new Book(bookId, bookName, authorDao.getAuthorById(authorId));

			bookDao.updateBook(book);
			book_bookTypeDao.updateBook_BookType(book, listbookType, bookTypeDao);

			response.sendRedirect("books");
		}
	}

	private void _getFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));

		List<Author> listAuthor = authorDao.getAuthors();
		List<BookType> listBookType = bookTypeDao.getAllBookType();
		List<Integer> listBookTypeIdSelected = book_bookTypeDao.getListBookTypeIdByBookId(bookId);

		request.setAttribute("listAuthor", listAuthor);
		request.setAttribute("listBookType", listBookType);
		request.setAttribute("listBookTypeSelected", listBookTypeIdSelected);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(HibernateCommandNames.VIEW_FORM);
		dispatcher.forward(request, response);
	}

	final static Logger logger = Logger.getLogger(EditBookServlet.class);

}
