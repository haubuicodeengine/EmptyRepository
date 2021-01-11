package com.liferay.practice.course.management.util.validator;

import com.liferay.practice.course.management.exception.CourseAlreadyRegisteredException;
import com.liferay.practice.course.management.exception.CourseFullRegisteredException;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.validator.RegistrationValidator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = RegistrationValidator.class)
public class RegistrationValidatorImpl implements RegistrationValidator {

	@Override
	public void validate(long courseId, long userId, List<Registration> registrations)
			throws CourseFullRegisteredException, CourseAlreadyRegisteredException {

		isCourseAlreadyRegistered(courseId, userId, registrations);
		isCourseFullRegistered(courseId, registrations);
	}

	private void isCourseAlreadyRegistered(long courseId, long userId, List<Registration> registrations)
			throws CourseAlreadyRegisteredException {

		if (!registrations.isEmpty()) {

			for (Registration registration : registrations) {

				if (registration.getUserId() == userId && registration.getCourseId() == courseId) {

					throw new CourseAlreadyRegisteredException("alreadyRegistered");
				}
			}
		}
	}

	private void isCourseFullRegistered(long courseId, List<Registration> registrations)
			throws CourseFullRegisteredException {

		int registered = 0;

		for (Registration registration : registrations) {

			if (registration.getCourseId() == courseId) {

				registered = registered + 1;
			}
		}

		if (registered >= _MAXIMUM_REGISTER_FOR_A_COURSE) {

			throw new CourseFullRegisteredException("fullRegistered");
		}
	}

	private final int _MAXIMUM_REGISTER_FOR_A_COURSE = 20;
}
