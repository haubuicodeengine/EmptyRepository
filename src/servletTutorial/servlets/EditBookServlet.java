package servletTutorial.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletTutorial.contants.ServletCommandNames;
import servletTutorial.repository.BookRepository;
import servletTutorial.validation.BookValidator;

public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));

		try {
			request.setAttribute("bookEdit", BookRepository.getBookById(bookId));
			_getFile(request, response);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + ServletCommandNames.URL_ERROR);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("id"));
		String bookName = request.getParameter("name");
		String author = request.getParameter("author");
		List<String> errors = BookValidator.validate(bookId, bookName);

		if (errors.size() > 0) {
			request.setAttribute("errors", errors);

			_getFile(request, response);
		} else {
			BookRepository.editBook(bookId, bookName, author);
			response.sendRedirect(request.getContextPath() + ServletCommandNames.URL_LIST);
		}
	}

	private void _getFile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(ServletCommandNames.VIEW_FORM);
		dispatcher.forward(request, response);
	}

}
