package com.liferay.course.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CourseRegistrationValidationException extends PortalException {

	public CourseRegistrationValidationException() {
	}

	public CourseRegistrationValidationException(String msg) {
		super(msg);
	}

	public CourseRegistrationValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CourseRegistrationValidationException(Throwable cause) {
		super(cause);
	}
	
	public static class CourseRegistrationMustNotBeDuplicate extends CourseRegistrationValidationException {

		public CourseRegistrationMustNotBeDuplicate() {
			super(
				String.format(
					"This course must not be duplicate but is already"));
		}

	}

	private static final long serialVersionUID = 1L;


}