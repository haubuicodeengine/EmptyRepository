package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.validation.BookValidation;
import hibernate.dao.AuthorDao;
import hibernate.dao.BookDao;
import hibernate.dao.BookTypeDao;
import hibernate.dao.Book_BookTypeDao;
import hibernate.entities.Author;
import hibernate.entities.Book;
import hibernate.entities.BookType;

/**
 * Servlet implementation class EditBookServlet
 */
@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private AuthorDao authorDao;
	private BookTypeDao bookTypeDao;
	private Book_BookTypeDao book_bookTypeDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		bookDao = new BookDao();
		authorDao = new AuthorDao();
		bookTypeDao = new BookTypeDao();
		book_bookTypeDao = new Book_BookTypeDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getFile(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		int authorId = Integer.parseInt(request.getParameter("author.authorId"));

		String[] listbookType = request.getParameterValues("bookTypeSelected");

		if (!BookValidation.checkEmpty(bookName)) {
			request.setAttribute("error", "The book's name is not null.");
			getFile(request, response);

		} else if (!BookValidation.checkExisted(bookId, bookName, bookDao.getAllBook())) {
			request.setAttribute("error", "The book's name is existed.");
			getFile(request, response);

		} else {
			Book book = new Book(bookId, bookName, authorDao.getAuthorById(authorId));
			bookDao.updateBook(book);

			List<Integer> listBookTypeChecked = book_bookTypeDao.getListBookTypeIdByBookId(bookId);
			if (listbookType != null) {
				// check bookType existed in db
				for (String bookTypeId : listbookType) {
					if (BookValidation.checkBookTypeExisted(book_bookTypeDao.getAllBook_BookType(), bookId,
							Integer.parseInt(bookTypeId))) {
						book_bookTypeDao.saveItem(book, bookTypeDao.getBookTypeById(Integer.parseInt(bookTypeId)));
					}
				}
				// check bookType is removed
				for (int i = 0; i < listbookType.length; i++) {
					for (int bookTypeId : listBookTypeChecked) {
						if (bookTypeId == Integer.parseInt(listbookType[i])) {
							book_bookTypeDao.deleteBook_BookTypeByBookTypeId(bookTypeId);
						}
					}
				}
			} // check list bookType remove all
			else {
				book_bookTypeDao.deleteBook_BookTypeDaoByBookId(bookId);
			}
			response.sendRedirect("books");
		}
	}

	public void getFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = Integer.parseInt(request.getParameter("bookId"));

		Book bookEdit = bookDao.getBookById(bookId);
		List<Author> listAuthor = authorDao.getAllAuthor();
		List<BookType> listBookType = bookTypeDao.getAllBookType();
		List<Integer> listBookTypeIdSelected = book_bookTypeDao.getListBookTypeIdByBookId(bookId);

		request.setAttribute("bookEdit", bookEdit);
		request.setAttribute("listAuthor", listAuthor);
		request.setAttribute("listBookType", listBookType);
		request.setAttribute("listBookTypeSelected", listBookTypeIdSelected);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
		dispatcher.forward(request, response);
	}
}
