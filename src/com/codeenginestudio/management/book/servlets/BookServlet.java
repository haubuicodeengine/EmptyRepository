package com.codeenginestudio.management.book.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codeenginestudio.management.book.repository.BookRepository;
import com.codeenginestudio.management.book.util.BookUtil;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listBooks", BookRepository.getBooks());
		BookUtil.displayView(request, response, "/static/view/book/list-book.jsp");
	}

	private static final long serialVersionUID = 1L;
}
