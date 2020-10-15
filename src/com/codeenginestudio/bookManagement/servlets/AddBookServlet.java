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
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static ManageBook manageBook = new ManageBook();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		request.setAttribute("url", "/AddBook");
		displayView(request, response, "/AddOrEditBook.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String bookName = request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");

		if(bookName.equals("")) {

			request.setAttribute("book", new Book(bookName, bookAuthor));
			request.setAttribute("bookNameErr", "Name of book could not be blank");
			request.setAttribute("url", "/AddBook");
			displayView(request, response, "/AddOrEditBook.jsp");
		} else {

			manageBook.addNewBook(bookName, bookAuthor);
			request.setAttribute("listBooks", manageBook.getListBooks());
			displayView(request, response, "/Home.jsp");
		}

	}

}
