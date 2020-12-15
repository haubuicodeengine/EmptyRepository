package com.codeenginestudio.management.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.management.book.repository.BookRepository;

@WebServlet("/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookRepository.deleteBook(bookId);
		response.sendRedirect(request.getContextPath() + "/Book/");
	}

	private static final long serialVersionUID = 1L;
}
