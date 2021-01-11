package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class RegistrationValidatorException extends PortalException {

	private static final long serialVersionUID = 1L;

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
}
