package com.codeenginestudio.management.book.validator;

import java.util.HashMap;
import java.util.Map;

import com.codeenginestudio.management.book.models.Book;

public class BookValidator {

	public static Map<String, String> validate(Book book) {

		Map<String, String> errors = new HashMap<>();

		if (checkNullValue(book.getBookName())) {

			errors.put(_BOOK_NAME, "Book name could not be empty!");
		}

		return errors;
	}

	public static boolean checkNullValue(String value) {

		if (value == null || value.trim().length() == 0) {

			return true;
		}

		return false;
	}

	private static final String _BOOK_NAME = "bookName";
}
