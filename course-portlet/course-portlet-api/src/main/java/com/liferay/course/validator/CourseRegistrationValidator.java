
package com.liferay.course.validator;

import com.liferay.course.exception.CourseRegistrationValidationException;
import com.liferay.course.model.CourseRegistration;

import java.util.List;

public interface CourseRegistrationValidator {

	public void validate(
			long courseId, long userId, List<CourseRegistration> list)
		throws CourseRegistrationValidationException;

}