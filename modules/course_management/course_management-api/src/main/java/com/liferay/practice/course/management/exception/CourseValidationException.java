package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

public class CourseValidationException extends PortalException {

	private static final long serialVersionUID = 1L;

	public CourseValidationException(List<String> errors) {

		super(String.join(",", errors));
		_errors = errors;
	}

	public List<String> getErrors() {

		return _errors;
	}

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

	private List<String> _errors;
}