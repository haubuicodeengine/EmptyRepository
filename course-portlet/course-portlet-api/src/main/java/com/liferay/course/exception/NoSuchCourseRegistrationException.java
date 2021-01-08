package com.liferay.course.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

public class NoSuchCourseRegistrationException extends NoSuchModelException {

	public NoSuchCourseRegistrationException() {
	}

	public NoSuchCourseRegistrationException(String msg) {
		super(msg);
	}

	public NoSuchCourseRegistrationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchCourseRegistrationException(Throwable cause) {
		super(cause);
	}

}