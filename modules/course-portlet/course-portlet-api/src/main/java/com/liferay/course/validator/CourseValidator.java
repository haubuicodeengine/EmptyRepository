package com.liferay.course.validator;

import com.liferay.course.exception.CourseValidationException;

import java.util.Locale;
import java.util.Map;

public interface CourseValidator {

	public void validate(Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration) throws CourseValidationException;

}
