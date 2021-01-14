package com.liferay.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserRegistrationReminderQueryException extends PortalException {

	public UserRegistrationReminderQueryException() {
	}

	public UserRegistrationReminderQueryException(String msg) {
		super(msg);
	}

	public UserRegistrationReminderQueryException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public UserRegistrationReminderQueryException(Throwable cause) {
		super(cause);
	}

	public static class AnswerMustBeShorter
		extends UserRegistrationReminderQueryException {

		public AnswerMustBeShorter(int maxLength) {
			super(
				String.format(
					"Answer must be at most %s characters", maxLength));

			this.maxLength = maxLength;
		}

		public final int maxLength;

	}

	public static class AnswerMustNotBeNull
		extends UserRegistrationReminderQueryException {

		public AnswerMustNotBeNull() {
			super(String.format("Answer for user must not be null"));
		}

	}

	public static class SecurityQuestionMustNotBeNull
		extends UserRegistrationReminderQueryException {

		public SecurityQuestionMustNotBeNull() {
			super(String.format("Security question for user must not be null"));
		}

	}

	private static final long serialVersionUID = 1L;

}