package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class DurationValueException extends PortalException {

	public DurationValueException() {

	}

	public DurationValueException(String msg) {
		super(msg);
	}

	public DurationValueException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public DurationValueException(Throwable throwable) {
		super(throwable);
	}
}