package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class StringNullException  extends PortalException {

	public StringNullException() {

	}

	public StringNullException(String msg) {
		super(msg);
	}

	public StringNullException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public StringNullException(Throwable throwable) {
		super(throwable);
	}

}