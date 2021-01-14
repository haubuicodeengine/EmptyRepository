package com.liferay.amf.registration.validator;

import com.liferay.amf.registration.exception.UserCustomRegistrationValidationException;
import com.liferay.amf.registration.exception.UserRegistrationReminderQueryException;
import com.liferay.amf.registration.exception.UserRegistrationValidationException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;

public interface UserRegistrationValidator {

	public void validate(
			long userId, String password1, String password2, String screenName,
			String emailAddress, String firstName, String lastName,
			int birthdayMonth, int birthdayDay, int birthdayYear)
		throws UserEmailAddressException, UserPasswordException,
			   UserRegistrationValidationException, UserScreenNameException;

	public void validateReminderQuery(
			long userId, String question, String answer)
		throws UserRegistrationReminderQueryException;

	public void validateUserCustom(
			long userId, String homePhone, String mobilePhone)
		throws UserCustomRegistrationValidationException;

}