package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CourseFullRegisteredException extends PortalException {

	public CourseFullRegisteredException() {

	}

	public CourseFullRegisteredException(String msg) {
		super(msg);
	}

	public CourseFullRegisteredException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public CourseFullRegisteredException(Throwable throwable) {
		super(throwable);
	}
}
