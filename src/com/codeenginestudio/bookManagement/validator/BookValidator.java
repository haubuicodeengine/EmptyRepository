package com.codeenginestudio.bookManagement.validator;

public class BookValidator {

	public static Boolean _checkNullValue(String value) {

		if(value == "" || value == null) {

			return true;
		}

		return false;
	}

}
