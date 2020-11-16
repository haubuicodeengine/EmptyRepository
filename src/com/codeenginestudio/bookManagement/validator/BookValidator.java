package com.codeenginestudio.bookManagement.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookValidator {

	public static List<Map<String, String>> _validate(String bookName) {

		List<Map<String, String>> errors = new ArrayList<>();
		Map<String, String> results = new HashMap<>();

		if (_checkNullValue(bookName)) {

			results.put(_BOOK_NAME_ERROR, "Book name could not be empty!");
		}

		errors.add(results);

		return errors;
	}

	public static Boolean _checkNullValue(String value) {

		if (value == SPACE || value == null) {

			return true;
		}

		return false;
	}

	private static final String SPACE = "";
	private static final String _BOOK_NAME_ERROR = "bookNameError";
}
