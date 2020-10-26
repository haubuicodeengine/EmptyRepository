package hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.BookDao;
import hibernate.dao.Book_BookTypeDao;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private Book_BookTypeDao book_bookTypeDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		bookDao = new BookDao();
		book_bookTypeDao = new Book_BookTypeDao();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = Integer.parseInt(request.getParameter("id"));
		book_bookTypeDao.deleteBook_BookTypeDaoByBookId(bookId);
		bookDao.deleteBook(bookId);
		response.sendRedirect(request.getContextPath() + "/books");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
