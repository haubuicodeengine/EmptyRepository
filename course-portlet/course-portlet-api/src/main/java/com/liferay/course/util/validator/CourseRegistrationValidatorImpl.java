package com.liferay.course.util.validator;

import com.liferay.course.exception.CourseRegistrationValidationException;
import com.liferay.course.exception.CourseRegistrationValidationException.CourseRegistrationMustNotBeDuplicate;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.validator.CourseRegistrationValidator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	service = CourseRegistrationValidator.class
)
public class CourseRegistrationValidatorImpl
	implements CourseRegistrationValidator {

	public void validate(
			long courseId, long userId,
			List<CourseRegistration> courseRegistrations)
		throws CourseRegistrationValidationException {

		if (!checkRegisted(courseId, userId, courseRegistrations)) {
			throw new CourseRegistrationMustNotBeDuplicate();
		}
	}

	private boolean checkRegisted(
		long courseId, long userId,
		List<CourseRegistration> courseRegistrations) {

		boolean result = true;

		for (CourseRegistration courseRegistration : courseRegistrations) {
			if ((courseRegistration.getCourseId() == courseId) &&
				(courseRegistration.getUserId() == userId)) {

				return false;
			}
		}

		return result;
	}

}