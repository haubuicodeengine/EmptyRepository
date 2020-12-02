package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.constants.HibernateCommandNames;
import hibernate.dao.BookDao;
import hibernate.entities.Book;

@WebServlet("/books")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public void init() {
		bookDao = new BookDao();
	}

	public ListBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Book> listBook = bookDao.getBooks();

		request.setAttribute("listBook", listBook);

		RequestDispatcher dispatcher = request.getRequestDispatcher(HibernateCommandNames.VIEW_BOOKS);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
