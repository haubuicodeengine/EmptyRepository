package com.codeenginestudio.bookmanagement.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.codeenginestudio.bookmanagement.dto.BookDto;

public class BookValidator {

	public static Map<String, String> validate(BookDto savedBookDto, List<Long> typeIds) {

		Map<String, String> errors = new HashMap<>();

		if (checkNullValue(savedBookDto.getBookName())) {

			errors.put(_BOOK_NAME_ERROR, "Book's name could not be empty!");
		}

		if (typeIds == null) {

			errors.put(_BOOK_TYPE_ERROR, "Book's type could not be empty!");
		}

		return errors;
	}

	public static Boolean checkNullValue(String value) {

		if (value == null || value.trim().length() == 0) {

			return true;
		}

		return false;
	}

	private static final String _BOOK_NAME_ERROR = "bookName";
	private static final String _BOOK_TYPE_ERROR = "bookType";
}
