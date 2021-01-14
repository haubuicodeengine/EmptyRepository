package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserRegistrationValidationException extends PortalException {

	public UserRegistrationValidationException() {
	}

	public UserRegistrationValidationException(String msg) {
		super(msg);
	}

	public UserRegistrationValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserRegistrationValidationException(Throwable cause) {
		super(cause);
	}

	// Email Validation Exception

	public static class BirthdayMustNotBeNull
		extends UserRegistrationValidationException {

		public BirthdayMustNotBeNull() {
			super(String.format("Birthday for user must not be null"));
		}

	}

	// Username Validation Exception

	public static class BirthdayMustNotInFuture
		extends UserRegistrationValidationException {

		public BirthdayMustNotInFuture() {
			super(String.format("Birthday for user must not be in future"));
		}

	}

	public static class BirthdayMustNotSmaller13
		extends UserRegistrationValidationException {

		public BirthdayMustNotSmaller13() {
			super(String.format("Birthday for user must be more 13"));
		}

	}

	public static class DayInBirthdayMustCorrect
		extends UserRegistrationValidationException {

		public DayInBirthdayMustCorrect() {
			super(
				String.format("The day of birthday for user must be correct"));
		}

	}

	// FirstName Validation Exception

	public static class EmailMustBeShorter
		extends UserRegistrationValidationException {

		public EmailMustBeShorter(int maxLength) {
			super(
				String.format(
					"Email for user must be at most %s characters", maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class FirstNameMustBeShorter
		extends UserRegistrationValidationException {

		public FirstNameMustBeShorter(int maxLength) {
			super(
				String.format(
					"First name for user %s must be at most %s characters",
					maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	// LastName Validation Exception

	public static class FirstNameMustNotBeNull
		extends UserRegistrationValidationException {

		public FirstNameMustNotBeNull() {
			super(String.format("First name for user must not be null"));
		}

	}

	public static class LastNameMustBeShorter
		extends UserRegistrationValidationException {

		public LastNameMustBeShorter(int maxLength) {
			super(
				String.format(
					"Last name for user %s must be at most %s characters",
					maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	// birthday Validation Exception

	public static class LastNameMustNotBeNull
		extends UserRegistrationValidationException {

		public LastNameMustNotBeNull() {
			super(String.format("Last name for user must not be null"));
		}

	}

	public static class MonthInBirthdayMustCorrect
		extends UserRegistrationValidationException {

		public MonthInBirthdayMustCorrect() {
			super(
				String.format(
					"The month of birthday for user must be correct"));
		}

	}

	public static class UsernameMustBeLonger
		extends UserRegistrationValidationException {

		public UsernameMustBeLonger(int minLength) {
			super(
				String.format(
					"Username for user must be at least %s characters",
					minLength));

			this.minLength = minLength;
		}

		public final int minLength;

	}

	public static class UsernameMustBeShorter
		extends UserRegistrationValidationException {

		public UsernameMustBeShorter(int maxLength) {
			super(
				String.format(
					"Username for user must be at most %s characters",
					maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class UsernameMustNotBeDuplicate
		extends UserRegistrationValidationException {

		public UsernameMustNotBeDuplicate(String userName) {
			super(
				String.format(
					"A user with user name %s is already " + "in use",
					userName));

			this.userName = userName;
		}

		public String userName;

	}

	private static final long serialVersionUID = 1L;

}