package com.codeenginestudio.bookManagement.util;

import java.util.List;

public class BookTypeUtil {

	public static Boolean _checkDuplicateBooktype(List<String> currentTypes, String typeId) {

		if (currentTypes == null) {
			return false;
		}

		if (currentTypes.contains(typeId)) {
			return true;
		}

		return false;
	}
}
