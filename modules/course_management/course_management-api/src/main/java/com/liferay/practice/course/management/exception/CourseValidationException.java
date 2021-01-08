package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CourseValidationException extends PortalException {

	private static final long serialVersionUID = 1L;

	public CourseValidationException() {

	}

	public CourseValidationException(String msg) {
		super(msg);
	}

	public CourseValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CourseValidationException(Throwable cause) {
		super(cause);
	}
}