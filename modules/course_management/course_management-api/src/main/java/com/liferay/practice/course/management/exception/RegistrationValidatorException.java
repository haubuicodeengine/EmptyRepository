package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

public class RegistrationValidatorException extends PortalException {

	private static final long serialVersionUID = 1L;

	public RegistrationValidatorException(List<String> errors) {

		super(String.join(",", errors));
		_errors = errors;
	}

	public List<String> getErrors() {

		return _errors;
	}

	public RegistrationValidatorException() {
	}

	public RegistrationValidatorException(String msg) {
		super(msg);
	}

	public RegistrationValidatorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RegistrationValidatorException(Throwable cause) {
		super(cause);
	}

	private List<String> _errors;
}
