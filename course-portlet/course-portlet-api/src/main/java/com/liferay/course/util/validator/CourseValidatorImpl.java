package com.liferay.course.util.validator;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.exception.CourseValidationException.CourseNameMustNotBeNull;
import com.liferay.course.model.Course;
import com.liferay.course.exception.CourseValidationException.CourseNameMustBeLonger;
import com.liferay.course.exception.CourseValidationException.CourseLecturerMustBeLonger;
import com.liferay.course.exception.CourseValidationException.CourseLecturerMustNotBeNull;
import com.liferay.course.exception.CourseValidationException.CourseDurationValue;
import com.liferay.course.exception.CourseValidationException.CourseDescriptionMustBeLonger;
import com.liferay.course.exception.CourseValidationException.CourseNameMustNotBeDuplicate;
import com.liferay.course.validator.CourseValidator;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	service = CourseValidator.class
)
public class CourseValidatorImpl implements CourseValidator {

	public void validate(long courseId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration, List<Course> courses) throws CourseValidationException {

		if (!checkEmpty(courseNameMap)) {
			throw new CourseNameMustNotBeNull();
		}
		
		if (!checkCourseNameDuplicate(courseId, courseNameMap, courses)) {
			throw new CourseNameMustNotBeDuplicate();
		}

		if (!checkEmpty(lecturerMap)) {
			throw new CourseLecturerMustNotBeNull();
		}

		if (!checkMaxLength(courseNameMap, 75)) {
			throw new CourseNameMustBeLonger(75);
		}

		if (!checkMaxLength(lecturerMap, 75)) {
			throw new CourseLecturerMustBeLonger(75);
		}
		
		if (!checkMaxLength(descriptionMap, 2000)) {
			throw new CourseDescriptionMustBeLonger(2000);
		}

		if (!checkDurationValue(duration, 0, 40)) {
			throw new CourseDurationValue(0, 40);
		}

	}

	private boolean checkEmpty(Map<Locale, String> stringName) {

		boolean result = true;

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		if (Validator.isBlank(stringName.get(defaultLocale))) {
			result = false;
		}

		return result;
	}

	private boolean checkMaxLength(final Map<Locale, String> stringName, int maxLength) {

		boolean result = true;

		Locale defaultLocale = LocaleUtil.getSiteDefault();

		if (stringName.get(defaultLocale).length() > maxLength) {
			result = false;
		}

		return result;
	}

	private boolean checkDurationValue(final long duration, int min, int max) {

		boolean result = true;

		if (duration < min) {
			result = false;
		}
		if (duration > max) {
			result = false;
		}

		return result;
	}

	private boolean checkCourseNameDuplicate(long courseId, final Map<Locale, String> courseName, List<Course> courses) {

		boolean result = true;

		for(Course course: courses) {
			if(course.getCourseId() != courseId) {
				if(course.getCourseName().equals(courseName)) {
					return false;
				}
			}
		}

		return result;
	}
}