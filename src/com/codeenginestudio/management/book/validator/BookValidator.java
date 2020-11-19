package com.codeenginestudio.management.book.validator;

import java.util.HashMap;
import java.util.Map;

import com.codeenginestudio.management.book.model.Book;

public class BookValidator {

	public static Map<String, String> validate(Book book, String[] newTypes) {

		Map<String, String> errors = new HashMap<>();

		if (checkEmptyValue(book.getBookName())) {

			errors.put(_BOOK_NAME, "Book's name could not be empty!");
		}

		if(newTypes == null) {

			errors.put(_BOOK_TYPE, "Book's type could not be null!");
		}

		return errors;
	}
	
	public static boolean checkEmptyValue(String inputValue) {

		if (inputValue.equals(_SPACE)) {

			return true;
		}

		return false;
	}

	private static final String _SPACE = "";
	private static final String _BOOK_NAME = "bookName";
	private static final String _BOOK_TYPE = "bookType";
}
