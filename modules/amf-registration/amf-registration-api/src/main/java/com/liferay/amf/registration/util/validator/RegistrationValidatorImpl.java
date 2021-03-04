package com.liferay.amf.registration.util.validator;

import com.liferay.amf.registration.exception.CustomUserValidationException;
import com.liferay.amf.registration.exception.CustomUserValidationException.BlankFieldException;
import com.liferay.amf.registration.exception.CustomUserValidationException.FieldLengthException;
import com.liferay.amf.registration.exception.CustomUserValidationException.NumericValueException;
import com.liferay.amf.registration.validator.RegistrationValidator;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreNumbers;
import com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreSymbols;
import com.liferay.portal.kernel.exception.UserPasswordException.MustHaveMoreUppercase;
import com.liferay.portal.kernel.exception.UserPasswordException.MustMatch;
import com.liferay.portal.kernel.exception.UserScreenNameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = RegistrationValidator.class)
public class RegistrationValidatorImpl implements RegistrationValidator {

	@Override
	public void validate(long userId, String password, String confirmPassword, String username, String email,
			String firstName, String lastName, int birthdayMonth, int birthdayDay, int birthdayYear, String street1,
			String street2, String city, String zip, String homePhone, String mobilePhone, String security_answer, boolean acceptedTou)
			throws UserEmailAddressException, UserPasswordException, CustomUserValidationException,
			UserScreenNameException {

		_checkLength(firstName, 1, 50, "Firstname");
		_checkLength(lastName, 1, 50, "Lastname");
		_checkLength(email, 1, 255, "Email");
		_checkLength(username, 4, 16, "Username");
		_checkLength(street1, 1, 255, "Address1");
		_checkLength(street2, 1, 255, "Address2");
		_checkLength(city, 1, 255, "City");
		_checkLength(homePhone, 10, 10, "Home phone");
		_checkLength(mobilePhone, 10, 10, "mobile phone");
		_checkLength(security_answer, 1, 255, "Security answer");
		_checkLength(password, 6, 255, "Password");
		
		_checkStringContainUpperCaseLetter(password);
		_checkStringContainNumber(password);
		_checkStringContainSpecialCharacter(password);
		_checkPasswordMatch(userId, password, confirmPassword);

		_checkStringContainOnlyNumber(homePhone, "Home phone");
		_checkStringContainOnlyNumber(mobilePhone, "Mobile phone");
		
		_checkAcceptedTou(acceptedTou);

	}

	private void _checkLength(String inputValue, int minLength, int maxLength, String fieldName)
			throws FieldLengthException, BlankFieldException {

		if (inputValue.trim().contentEquals("")) {
			throw new CustomUserValidationException.BlankFieldException(
					fieldName + " could not be null!");
		}

		if (inputValue.trim().length() < minLength) {
			throw new CustomUserValidationException.FieldLengthException(
					fieldName + " is too short!");
		}

		if (inputValue.trim().length() > maxLength) {
			throw new CustomUserValidationException.FieldLengthException(fieldName + " is too long!");
		}
	}

	private void _checkPasswordMatch(long userId, String password1, String password2) throws MustMatch {

		if (!password1.equals(password2)) {
			throw new UserPasswordException.MustMatch(userId);
		}
	}

	private void _checkStringContainSpecialCharacter(String stringName) throws MustHaveMoreSymbols {

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

		Matcher matcher = pattern.matcher(stringName);

		boolean isStringContainsSpecialCharacter = matcher.find();

		if (!isStringContainsSpecialCharacter) {
			throw new UserPasswordException.MustHaveMoreSymbols(1);
		}
	}

	private void _checkStringContainUpperCaseLetter(String stringName) throws MustHaveMoreUppercase {

		char[] charArray = stringName.toCharArray();

		int count = 0;

		for (int i = 0; i < charArray.length; i++) {

			if (Character.isUpperCase(charArray[i])) {
				count++;
			}
		}

		if (count == 0) {
			throw new UserPasswordException.MustHaveMoreUppercase(1);
		}

	}

	private void _checkStringContainNumber(String stringName) throws MustHaveMoreNumbers {

		char[] charArray = stringName.toCharArray();

		int count = 0;

		for (int i = 0; i < charArray.length; i++) {

			if (Character.isDigit(charArray[i])) {
				count++;
			}
		}

		if (count == 0) {
			throw new UserPasswordException.MustHaveMoreNumbers(1);
		}
	}

	private void _checkStringContainOnlyNumber(String stringName, String fieldName) throws NumericValueException {

		char[] charArray = stringName.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			if (!Character.isDigit(charArray[i])) {
				throw new CustomUserValidationException.NumericValueException(fieldName + " is required only number");
			}
		}

	}
	
	private void _checkAcceptedTou(boolean acceptedTou) throws BlankFieldException {

		if(!acceptedTou) {
			throw new CustomUserValidationException.BlankFieldException("Terms of Use must be checked");
		}
	}

}
