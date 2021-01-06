package com.liferay.practice.course.management.validator;

import com.liferay.practice.course.management.exception.RegistrationValidatorException;
import com.liferay.practice.course.management.model.Registration;

import java.util.List;

public interface RegistrationValidator {

	public void validate(long courseId, long userId, List<Registration> registrations)
			throws RegistrationValidatorException;
}
