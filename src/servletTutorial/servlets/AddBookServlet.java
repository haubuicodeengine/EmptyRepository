package servletTutorial.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletTutorial.manage.BookManagement;
import servletTutorial.validation.BookValidation;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
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
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookId = BookManagement.getBooks().size() + 1;
		String bookName = request.getParameter("name");
		String author = request.getParameter("author");

		if (!BookValidation.checkEmpty(bookName)) {
			request.setAttribute("error", "The book's name is not null.");

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
			dispatcher.forward(request, response);

		} else if (!BookValidation.checkExisted(bookId, bookName)) {
			request.setAttribute("error", "This book's name is existed.");

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
			dispatcher.forward(request, response);

		} else {
			BookManagement.addBook(bookId, bookName, author);

			request.setAttribute("data", BookManagement.getBooks());
			response.sendRedirect(request.getContextPath() + "/books");
		}

	}
}
