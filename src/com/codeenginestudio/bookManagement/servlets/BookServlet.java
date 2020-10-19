package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("listBooks", manageBook.getListBooks());
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/Home.jsp");
		dispatcher.forward(request, response);
	}

	private static final long serialVersionUID = 1L;
	private ManageBook manageBook = new ManageBook();
}
