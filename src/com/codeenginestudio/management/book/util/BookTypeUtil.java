package com.codeenginestudio.management.book.util;

import java.util.List;

public class BookTypeUtil {

	public static Boolean checkDuplicateBooktype(List<Long> currentTypes, Long typeId) {

		if (currentTypes == null) {
			return false;
		}

		if (currentTypes.contains(typeId)) {
			return true;
		}

		return false;
	}
}
