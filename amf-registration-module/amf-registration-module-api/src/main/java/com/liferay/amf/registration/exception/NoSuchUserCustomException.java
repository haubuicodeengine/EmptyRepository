package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

public class NoSuchUserCustomException extends NoSuchModelException {

	public NoSuchUserCustomException() {
	}

	public NoSuchUserCustomException(String msg) {
		super(msg);
	}

	public NoSuchUserCustomException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchUserCustomException(Throwable cause) {
		super(cause);
	}

}