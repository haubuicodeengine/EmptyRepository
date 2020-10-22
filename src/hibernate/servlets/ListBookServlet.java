package hibernate.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate.dao.BookDao;
import hibernate.entities.Book;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/books")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public void init() {
		bookDao = new BookDao();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> listBooks = bookDao.getAllBook();
		request.setAttribute("listBooks", listBooks);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/listBooks/index.jsp");
		dispatcher.forward(request, response);
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
