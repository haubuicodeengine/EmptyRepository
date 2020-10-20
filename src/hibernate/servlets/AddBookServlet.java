package hibernate.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Hibernate.validation.BookValidation;
import hibernate.dao.BookDao;
import hibernate.entities.Book;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		bookDao = new BookDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
		dispatcher.forward(request, response);
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
        String author = request.getParameter("author");
        
        if (!BookValidation.checkEmpty(name)) {
        	request.setAttribute("error", "The book's name is not null.");

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
			dispatcher.forward(request, response);

        }else if(!BookValidation.checkExisted(id, name, bookDao.getAllBook())) {
        	request.setAttribute("error", "The book's name is existed.");

			RequestDispatcher dispatcher = this.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/addAndEditBook/index.jsp");
			dispatcher.forward(request, response);

        }else {
            Book newBook = new Book(name, author);
            bookDao.saveBook(newBook);
            response.sendRedirect("books");
        }
	}

}
