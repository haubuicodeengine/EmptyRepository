package com.codeenginestudio.bookManagement.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.bookManagement.manage.ManageBook;
import com.codeenginestudio.bookManagement.util.BookUtil;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		ManageBook.deleteBook(bookId);
		request.setAttribute("listBooks", ManageBook.getListBooks());
		BookUtil._displayView(request, response, "/view/Home.jsp");
	}

	private static final long serialVersionUID = 1L;
}
