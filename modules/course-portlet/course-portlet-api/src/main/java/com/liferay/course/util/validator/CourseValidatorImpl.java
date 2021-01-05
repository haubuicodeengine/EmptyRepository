package com.liferay.course.util.validator;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.validator.CourseValidator;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = CourseValidator.class)
public class CourseValidatorImpl implements CourseValidator {

	public void validate(Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration) throws CourseValidationException {
		List<String> errors = new ArrayList<>();

		if (!isCourseEmpty(courseNameMap, descriptionMap, lecturerMap, duration, errors)) {
			throw new CourseValidationException(errors);
		}

		if (!isCourseMaxLength(courseNameMap, descriptionMap, lecturerMap, duration, errors)) {
			throw new CourseValidationException(errors);
		}

		if (!checkDurationLength(duration, errors, 1, 40)) {
			throw new CourseValidationException(errors);
		}
	}

	private boolean isCourseEmpty(final Map<Locale, String> courseNameMap, final Map<Locale, String> descriptionMap,
			final Map<Locale, String> lecturerMap, long duration, final List<String> errors) {

		boolean result = true;

		result &= checkStringEmpty(courseNameMap, errors, "courseName");
		result &= checkStringEmpty(lecturerMap, errors, "courseLecturer");

		return result;
	}

	private boolean isCourseMaxLength(final Map<Locale, String> courseNameMap, final Map<Locale, String> descriptionMap,
			final Map<Locale, String> lecturerMap, long duration, final List<String> errors) {
		boolean result = true;

		result &= checkMaxLength(courseNameMap, 75, errors, "courseName");
		result &= checkMaxLength(descriptionMap, 2000, errors, "courseDescription");
		result &= checkMaxLength(lecturerMap, 75, errors, "courseLecturer");

		return result;
	}

	private boolean checkStringEmpty(Map<Locale, String> stringName, List<String> errors, String objectName) {
		boolean result = true;
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		if ((Validator.isBlank(stringName.get(defaultLocale)))) {
			errors.add("" + objectName + "Empty");
			result = false;
		}

		return result;
	}

	private boolean checkMaxLength(final Map<Locale, String> stringName, int length, final List<String> errors,
			String objectName) {
		boolean result = true;
		Locale defaultLocale = LocaleUtil.getSiteDefault();

		if (stringName.get(defaultLocale).length() > length) {
			errors.add("" + objectName + "TooLong");
			result = false;
		}

		return result;
	}

	private boolean checkDurationLength(final long duration, final List<String> errors, int min,
			int max) {
		boolean result = true;

		if (duration < min) {
			errors.add("courseDurationTooSmall");
			result = false;
		}
		if (duration > max) {
			errors.add("courseDurationTooLarge");
			result = false;
		}

		return result;
	}

} 
