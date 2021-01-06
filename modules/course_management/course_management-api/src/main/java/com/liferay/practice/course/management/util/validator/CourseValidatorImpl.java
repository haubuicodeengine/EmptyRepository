package com.liferay.practice.course.management.util.validator;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.practice.course.management.exception.CourseValidationException;
import com.liferay.practice.course.management.validator.CourseValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = CourseValidator.class)
public class CourseValidatorImpl implements CourseValidator {

	public void validate(Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration) throws CourseValidationException {

		List<String> errors = new ArrayList<>();

		if (!isCourseValid(courseNameMap, descriptionMap, lecturerMap, duration, errors)) {

			throw new CourseValidationException(errors);
		}
	}

	private boolean isCourseValid(final Map<Locale, String> courseNameMap, final Map<Locale, String> descriptionMap,
			final Map<Locale, String> lecturerMap, final Long duration, final List<String> errors) {

		boolean result = true;

		result &= isCourseNameValid(courseNameMap, errors);
		result &= isDescriptionValid(descriptionMap, errors);
		result &= isLecturerValid(lecturerMap, errors);
		result &= isDurationValid(duration, errors);

		return result;
	}

	private boolean isDurationValid(final Long duration, final List<String> errors) {

		boolean result = true;

		if (duration == null) {
			errors.add("courseDurationEmpty");
			result = false;
		} else {

			if (duration > 40) {
				errors.add("courseDurationValueInvalid");
				result = false;
			}
		}

		return result;
	}

	private boolean isLecturerValid(final Map<Locale, String> lecturerMap, final List<String> errors) {

		boolean result = true;

		if (MapUtil.isEmpty(lecturerMap)) {
			errors.add("courseLecturerEmpty");
			result = false;
		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(lecturerMap.get(defaultLocale)))) {
				errors.add("courseLecturerEmpty");
				result = false;
			} else {
				if (lecturerMap.get(defaultLocale).length() > 75) {
					errors.add("courseLecturerLengthInvalid");
					result = false;
				}
			}
		}

		return result;

	}

	private boolean isDescriptionValid(final Map<Locale, String> descriptionMap, final List<String> errors) {

		boolean result = true;

		if (MapUtil.isEmpty(descriptionMap)) {
			errors.add("courseDescriptionEmpty");
			result = false;
		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(descriptionMap.get(defaultLocale)))) {
				errors.add("courseDescriptionEmpty");
				result = false;
			} else {
				if (descriptionMap.get(defaultLocale).length() > 2000) {
					errors.add("courseDescriptionLengthInvalid");
					result = false;
				}
			}
		}

		return result;

	}

	private boolean isCourseNameValid(final Map<Locale, String> courseNameMap, final List<String> errors) {

		boolean result = true;

		if (MapUtil.isEmpty(courseNameMap)) {
			errors.add("courseNameEmpty");
			result = false;
		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(courseNameMap.get(defaultLocale)))) {
				errors.add("courseNameEmpty");
				result = false;
			} else {
				if (courseNameMap.get(defaultLocale).length() > 20) {
					errors.add("courseNameLengthInvalid");
					result = false;
				}
			}
		}

		return result;
	}
}
