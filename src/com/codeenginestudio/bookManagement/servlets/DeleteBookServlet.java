package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    public void displayView(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(fileName);
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		manageBook.deleteBook(bookId);
    	request.setAttribute("listBooks", manageBook.getListBooks());
		displayView(request, response, "/view/Home.jsp");
	}

	private static final long serialVersionUID = 1L;
	private ManageBook manageBook = new ManageBook();
}
