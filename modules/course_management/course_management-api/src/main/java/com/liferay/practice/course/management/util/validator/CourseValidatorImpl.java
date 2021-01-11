package com.liferay.practice.course.management.util.validator;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.practice.course.management.exception.DurationValueException;
import com.liferay.practice.course.management.exception.StringLengthException;
import com.liferay.practice.course.management.exception.StringNullException;
import com.liferay.practice.course.management.validator.CourseValidator;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = CourseValidator.class)
public class CourseValidatorImpl implements CourseValidator {

	public void validate(Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration)
			throws StringNullException, StringLengthException, DurationValueException {

		isCourseNameValid(courseNameMap);
		isDescriptionValid(descriptionMap);
		isLecturerValid(lecturerMap);
		isDurationValid(duration);
	}

	private void isDurationValid(final Long duration) throws DurationValueException {

		if (duration == null) {

			throw new DurationValueException("courseDurationEmpty");
		} else {

			if (duration > _DURATION_MAX_LENGHT) {

				throw new DurationValueException("courseDurationValueInvalid");
			}
		}

	}

	private void isLecturerValid(final Map<Locale, String> lecturerMap)
			throws StringNullException, StringLengthException {

		if (MapUtil.isEmpty(lecturerMap)) {

			throw new StringNullException("courseLecturerEmpty");
		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(lecturerMap.get(defaultLocale)))) {

				throw new StringNullException("courseLecturerEmpty");
			} else {

				if (lecturerMap.get(defaultLocale).length() > _LECTURER_MAX_LENGHT) {

					throw new StringLengthException("courseLecturerLengthInvalid");
				}
			}
		}
	}

	private void isDescriptionValid(final Map<Locale, String> descriptionMap)
			throws StringNullException, StringLengthException {

		if (MapUtil.isEmpty(descriptionMap)) {

			throw new StringNullException("courseDescriptionEmpty");
		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(descriptionMap.get(defaultLocale)))) {

				throw new StringNullException("courseDescriptionEmpty");
			} else {

				if (descriptionMap.get(defaultLocale).length() > _DESCRIPTION_MAX_LENGHT) {

					throw new StringLengthException("courseDescriptionLengthInvalid");
				}
			}
		}

	}

	private void isCourseNameValid(final Map<Locale, String> courseNameMap)
			throws StringNullException, StringLengthException {

		if (MapUtil.isEmpty(courseNameMap)) {

			throw new StringNullException("cousreNameEmpty");

		} else {

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			if ((Validator.isBlank(courseNameMap.get(defaultLocale)))) {

				throw new StringNullException("cousreNameEmpty");
			} else {

				if (courseNameMap.get(defaultLocale).length() > _COURSE_NAME_MAX_LENGHT) {

					throw new StringLengthException("courseNameLengthInvalid");
				}
			}
		}
	}

	private final int _DURATION_MAX_LENGHT = 40;
	private final int _COURSE_NAME_MAX_LENGHT = 20;
	private final int _LECTURER_MAX_LENGHT = 75;
	private final int _DESCRIPTION_MAX_LENGHT = 2000;
}
