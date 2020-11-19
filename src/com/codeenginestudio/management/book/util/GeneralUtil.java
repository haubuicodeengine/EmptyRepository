package com.codeenginestudio.management.book.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GeneralUtil {

	public static void displayView(HttpServletRequest request, HttpServletResponse response, String fileName)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		RequestDispatcher dispatcher = sc.getRequestDispatcher(fileName);
		dispatcher.forward(request, response);
	}

	public static List<Long> convertArrayStringToListLong(String[] strArray) {

		List<Long> newList = new ArrayList<>();

		for (String string : strArray) {
			newList.add(Long.parseLong(string));
		}

		return newList;
	}
}
