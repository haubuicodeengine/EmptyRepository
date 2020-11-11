package com.codeenginestudio.bookManagement.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BookUtil {

	public static void _displayView(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {

		HttpSession session = request.getSession();      
        ServletContext sc = session.getServletContext();
        RequestDispatcher dispatcher = sc.getRequestDispatcher(fileName);
		dispatcher.forward(request, response);
	}
	
}
