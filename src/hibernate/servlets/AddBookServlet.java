package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.validation.BookValidator;
import hibernate.constants.HibernateCommandNames;
import hibernate.dao.AuthorDao;
import hibernate.dao.BookDao;
import hibernate.dao.BookTypeDao;
import hibernate.dao.Book_BookTypeDao;
import hibernate.entities.Author;
import hibernate.entities.Book;
import hibernate.entities.BookType;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private AuthorDao authorDao;
	private BookTypeDao bookTypeDao;
	private Book_BookTypeDao book_bookTypeDao;

	public AddBookServlet() {
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
		_getFile(request, response);
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
			Book newBook = new Book(bookName, authorDao.getAuthorById(authorId));

			bookDao.saveBook(newBook);
			book_bookTypeDao.updateBook_BookType(newBook, listbookType, bookTypeDao);

			response.sendRedirect("books");
		}
	}

	private void _getFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Author> listAuthor = authorDao.getAuthors();
		List<BookType> listBookType = bookTypeDao.getAllBookType();

		request.setAttribute("listAuthor", listAuthor);
		request.setAttribute("listBookType", listBookType);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(HibernateCommandNames.VIEW_FORM);
		dispatcher.forward(request, response);
	}
}
