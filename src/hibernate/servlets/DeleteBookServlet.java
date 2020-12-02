package hibernate.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.constants.HibernateCommandNames;
import hibernate.dao.BookDao;
import hibernate.dao.Book_BookTypeDao;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	private Book_BookTypeDao book_bookTypeDao;

	public DeleteBookServlet() {
		super();
	}

	public void init() {
		bookDao = new BookDao();
		book_bookTypeDao = new Book_BookTypeDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));

		book_bookTypeDao.deleteBook_BookTypeByBookId(bookId);
		bookDao.deleteBook(bookId);

		response.sendRedirect(request.getContextPath() + HibernateCommandNames.URL_LIST);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
