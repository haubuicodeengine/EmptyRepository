package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class StringLengthException  extends PortalException {

	public StringLengthException() {

	}

	public StringLengthException(String msg) {
		super(msg);
	}

	public StringLengthException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public StringLengthException(Throwable throwable) {
		super(throwable);
	}

}