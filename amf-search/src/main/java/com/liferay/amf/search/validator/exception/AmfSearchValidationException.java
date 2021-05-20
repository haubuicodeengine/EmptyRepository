package com.liferay.amf.search.validator.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class AmfSearchValidationException extends PortalException {

	public AmfSearchValidationException() {
	}

	public AmfSearchValidationException(String msg) {
		super(msg);
	}

	public AmfSearchValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AmfSearchValidationException(Throwable cause) {
		super(cause);
	}

	public static class ZipCodeMustBe5Digits extends AmfSearchValidationException {

		public ZipCodeMustBe5Digits() {
			super(String.format("Zip code for user must be at 5 characters"));
		}

	}

	public static class ZipCodeMustNotBeNull extends AmfSearchValidationException {

		public ZipCodeMustNotBeNull() {
			super(String.format("Zip code must not be null"));
		}

	}

	private static final long serialVersionUID = 1L;

}
