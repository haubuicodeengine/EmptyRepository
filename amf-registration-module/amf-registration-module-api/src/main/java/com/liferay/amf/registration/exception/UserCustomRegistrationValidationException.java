package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserCustomRegistrationValidationException extends PortalException {

	public UserCustomRegistrationValidationException() {
	}

	public UserCustomRegistrationValidationException(String msg) {
		super(msg);
	}

	public UserCustomRegistrationValidationException(
		String msg, Throwable cause) {

		super(msg, cause);
	}

	public UserCustomRegistrationValidationException(Throwable cause) {
		super(cause);
	}

	public static class HomePhoneMustBe10Digits
		extends UserCustomRegistrationValidationException {

		public HomePhoneMustBe10Digits() {
			super(
				String.format("Home phone for user must be at 10 characters"));
		}

	}

	public static class MobilePhoneMustBe10Digits
		extends UserCustomRegistrationValidationException {

		public MobilePhoneMustBe10Digits() {
			super(
				String.format(
					"Mobile phone for user must be at 10 characters"));
		}

	}

	private static final long serialVersionUID = 1L;

}