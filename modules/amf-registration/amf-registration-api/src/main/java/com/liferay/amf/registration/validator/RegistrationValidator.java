package com.liferay.amf.registration.validator;

import com.liferay.amf.registration.exception.CustomUserValidationException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;

public interface RegistrationValidator {

	public void validate(long userId, String password, String confirmPassword, String username, String email,
			String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear, String street1,
			String street2, String city, String zip, String homePhone, String mobilePhone, String security_answer, boolean acceptedTou)
			throws UserEmailAddressException, UserPasswordException, CustomUserValidationException,
			UserScreenNameException;
}
