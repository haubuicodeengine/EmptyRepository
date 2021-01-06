package com.liferay.practice.course.management.util.validator;

import com.liferay.practice.course.management.exception.RegistrationValidatorException;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.validator.RegistrationValidator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = RegistrationValidator.class)
public class RegistrationValidatorImpl implements RegistrationValidator {

	@Override
	public void validate(long courseId, long userId, List<Registration> registrations)
			throws RegistrationValidatorException {

		List<String> errors = new ArrayList<>();

		if (!_isRegistrationValid(courseId, userId, errors, registrations)) {

			throw new RegistrationValidatorException(errors);
		}
	}

	private boolean _isRegistrationValid(long courseId, long userId, List<String> errors,
			List<Registration> registrations) {

		boolean result = true;

		result &= _isCourseAlreadyRegistered(courseId, userId, errors, registrations);
		result &= _isCourseFullRegistered(courseId, errors, registrations);
		return result;
	}

	private boolean _isCourseAlreadyRegistered(long courseId, long userId, List<String> errors,
			List<Registration> registrations) {

		if (!registrations.isEmpty()) {

			for (Registration registration : registrations) {

				if (registration.getUserId() == userId && registration.getCourseId() == courseId) {

					errors.add("alreadyRegistered");
					return false;
				}
			}
		}

		return true;
	}

	private boolean _isCourseFullRegistered(long courseId, List<String> errors, List<Registration> registrations) {

		int registered = 0;

		for (Registration registration : registrations) {

			if (registration.getCourseId() == courseId) {

				registered = registered + 1;
			}
		}

		if (registered >= 20) {

			errors.add("fullRegistered");
			return false;
		}

		return true;
	}
}
