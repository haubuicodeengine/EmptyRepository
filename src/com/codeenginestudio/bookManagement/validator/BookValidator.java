package com.codeenginestudio.bookManagement.validator;

public class BookValidator {

	public static Boolean _checkEmptyValue(String inputValue) {

		if (inputValue.equals("")) {
			return true;
		}

		return false;
	}
}
