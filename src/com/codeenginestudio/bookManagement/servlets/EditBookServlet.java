package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;
import com.codeenginestudio.bookManagement.models.Book;
import com.codeenginestudio.bookManagement.utils.BookUtil;

/**
 * Servlet implementation class EditBook
 */
@WebServlet("/EditBook")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ManageBook manageBook = new ManageBook();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void displayView(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(fileName);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		request.setAttribute("url", "/EditBook");
		request.setAttribute("book", manageBook.getOneBook(bookId));
		RequestDispatcher dispatcher = this.getServletContext()
                .getRequestDispatcher("/AddOrEditBook.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");

		if(bookName.equals("")) {

			request.setAttribute("book", new Book(bookId, bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("url", "/EditBook");
			displayView(request, response, "/AddOrEditBook.jsp");
		}else {

			manageBook.editBook(bookId, bookName, bookAuthor);
			request.setAttribute("listBooks", manageBook.getListBooks());
			displayView(request, response, "/Home.jsp");
		}
	}

}
