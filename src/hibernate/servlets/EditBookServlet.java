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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int authorId = Integer.parseInt(request.getParameter("author.authorId"));

		if (!BookValidation.checkEmpty(name)) {
			request.setAttribute("error", "The book's name is not null.");
			getFile(request, response);

		} else if (!BookValidation.checkExisted(id, name, bookDao.getAllBook())) {
			request.setAttribute("error", "The book's name is existed.");
			getFile(request, response);

		} else {
			Book book = new Book(id, name, authorDao.getAuthorById(authorId));
			bookDao.updateBook(book);
			response.sendRedirect("books");
		}
	}

	public void getFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		Book bookEdit = bookDao.getBookById(id);
		List<Author> listAuthor = authorDao.getAllAuthor();
		List<BookType> listBookType = bookTypeDao.getAllBookType();

		request.setAttribute("bookEdit", bookEdit);
		request.setAttribute("listAuthor", listAuthor);
		request.setAttribute("listBookType", listBookType);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
		dispatcher.forward(request, response);
	}
}
