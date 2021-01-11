package com.liferay.practice.course.management.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class CourseAlreadyRegisteredException extends PortalException {

	public CourseAlreadyRegisteredException() {

	}

	public CourseAlreadyRegisteredException(String msg) {
		super(msg);
	}

	public CourseAlreadyRegisteredException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public CourseAlreadyRegisteredException(Throwable throwable) {
		super(throwable);
	}
}