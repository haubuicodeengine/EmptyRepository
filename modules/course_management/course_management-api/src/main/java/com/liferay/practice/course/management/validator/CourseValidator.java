package com.liferay.practice.course.management.validator;

import com.liferay.practice.course.management.exception.CourseValidationException;

import java.util.Locale;
import java.util.Map;

public interface CourseValidator {

	public void validate(Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration) throws CourseValidationException;
}
