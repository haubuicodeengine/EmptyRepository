package com.liferay.course.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

public class NoSuchCourseException extends NoSuchModelException {

	public NoSuchCourseException() {
	}

	public NoSuchCourseException(String msg) {
		super(msg);
	}

	public NoSuchCourseException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCourseException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;

}