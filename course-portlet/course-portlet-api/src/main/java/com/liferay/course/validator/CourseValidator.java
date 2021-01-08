package com.liferay.course.validator;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.model.Course;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface CourseValidator {

	public void validate(long courseId,
			Map<Locale, String> courseNameMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> lecturerMap,
			long duration, List<Course> courses)
		throws CourseValidationException;

}