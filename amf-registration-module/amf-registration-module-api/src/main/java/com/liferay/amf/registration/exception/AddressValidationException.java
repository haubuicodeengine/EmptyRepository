package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class AddressValidationException extends PortalException {

	public AddressValidationException() {
	}

	public AddressValidationException(String msg) {
		super(msg);
	}

	public AddressValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AddressValidationException(Throwable cause) {
		super(cause);
	}

	public static class AddressMustBeShorter
		extends AddressValidationException {

		public AddressMustBeShorter(int maxLength) {
			super(
				String.format(
					"Address for user must be at most %s characters",
					maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class AddressMustNotBeNull
		extends AddressValidationException {

		public AddressMustNotBeNull() {
			super(String.format("Address must not be null"));
		}

	}

	public static class CityMustBeShorter extends AddressValidationException {

		public CityMustBeShorter(int maxLength) {
			super(
				String.format(
					"City for user must be at most %s characters", maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class CityMustNotBeNull extends AddressValidationException {

		public CityMustNotBeNull() {
			super(String.format("City must not be null"));
		}

	}

	public static class ZipCodeMustBe5Digits
		extends AddressValidationException {

		public ZipCodeMustBe5Digits() {
			super(String.format("Zip code for user must be at 5 characters"));
		}

	}

	public static class ZipCodeMustNotBeNull
		extends AddressValidationException {

		public ZipCodeMustNotBeNull() {
			super(String.format("Zip code must not be null"));
		}

	}

	private static final long serialVersionUID = 1L;

}