package com.liferay.course.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CourseValidationException extends PortalException {

	public CourseValidationException() {
	}

	public CourseValidationException(String msg) {
		super(msg);
	}

	public CourseValidationException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public CourseValidationException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 1L;
	
	public static class CourseNameMustNotBeNull extends CourseValidationException {

		public CourseNameMustNotBeNull() {
			super("Course name must not be null");
		}

	}
	
	public static class CourseLecturerMustNotBeNull extends CourseValidationException {

		public CourseLecturerMustNotBeNull() {
			super("Course lecturer must not be null");
		}

	}
	
	public static class CourseDurationMustNotBeNull extends CourseValidationException {

		public CourseDurationMustNotBeNull() {
			super("Course duration must not be null");
		}

	}
	
	public static class CourseNameMustBeLonger extends CourseValidationException {

		public CourseNameMustBeLonger(int maxLenghth) {
			super(
				String.format(
					"CourseName for course %s must be at most %s characters", maxLenghth));

			this.maxLenghth = maxLenghth;
		}

		public final int maxLenghth;
	}
	
	public static class CourseLecturerMustBeLonger extends CourseValidationException {

		public CourseLecturerMustBeLonger(int maxLenghth) {
			super(
				String.format(
					"Lecturer for course %s must be at most %s characters", maxLenghth));

			this.maxLenghth = maxLenghth;
		}

		public final int maxLenghth;
	}
	
	public static class CourseDescriptionMustBeLonger extends CourseValidationException {

		public CourseDescriptionMustBeLonger(int maxLenghth) {
			super(
				String.format(
					"Description for course %s must be at most %s characters", maxLenghth));

			this.maxLenghth = maxLenghth;
		}

		public final int maxLenghth;
	}
	
	public static class CourseDurationValue extends CourseValidationException {

		public CourseDurationValue(int min, int max) {
			super(
				String.format(
					"Duration for course must be between %s and %s", min, max));

			this.min = min;
			this.max = max;
		}

		public final int min;
		public final int max;
	}
	
	public static class CourseNameMustNotBeDuplicate extends CourseValidationException {

		public CourseNameMustNotBeDuplicate() {
			super(
				String.format(
					"Course name %s must not be duplicate but is already"));
		}

	}
}