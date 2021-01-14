package com.liferay.amf.registration.validator.impl;

import com.liferay.amf.registration.exception.UserCustomRegistrationValidationException;
import com.liferay.amf.registration.exception.UserRegistrationReminderQueryException;
import com.liferay.amf.registration.exception.UserRegistrationValidationException;
import com.liferay.amf.registration.validator.UserRegistrationValidator;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.Period;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = UserRegistrationValidator.class
)
public class UserRegistrationValidatorImpl
	implements UserRegistrationValidator {

	@Override
	public void validate(
			long userId, String password1, String password2, String userName,
			String emailAddress, String firstName, String lastName,
			int birthdayMonth, int birthdayDay, int birthdayYear)
		throws UserEmailAddressException, UserPasswordException,
			   UserRegistrationValidationException, UserScreenNameException {

		if (!checkNull(userName)) {
			throw new UserScreenNameException.MustNotBeNull();
		}

		if (!checkNull(password1)) {
			throw new UserPasswordException.MustNotBeNull(userId);
		}

		if (!checkNull(emailAddress)) {
			throw new UserEmailAddressException.MustNotBeNull();
		}

		if (!checkNull(firstName)) {
			throw new UserRegistrationValidationException.
				FirstNameMustNotBeNull();
		}

		if (!checkNull(lastName)) {
			throw new UserRegistrationValidationException.
				LastNameMustNotBeNull();
		}

		if (!checkMaxLength(userName, 16)) {
			throw new UserRegistrationValidationException.UsernameMustBeShorter(
				16);
		}

		if (!checkMaxLength(emailAddress, 255)) {
			throw new UserRegistrationValidationException.EmailMustBeShorter(
				255);
		}

		if (!checkMaxLength(firstName, 50)) {
			throw new UserRegistrationValidationException.
				FirstNameMustBeShorter(50);
		}

		if (!checkMaxLength(lastName, 50)) {
			throw new UserRegistrationValidationException.LastNameMustBeShorter(
				50);
		}

		if (!checkMinLength(userName, 4)) {
			throw new UserRegistrationValidationException.UsernameMustBeLonger(
				4);
		}

		if (!checkMinLength(password1, 6)) {
			throw new UserPasswordException.MustBeLonger(userId, 6);
		}

		if (!checkStringContainNumber(password1)) {
			throw new UserPasswordException.MustHaveMoreNumbers(1);
		}

		if (!checkStringContainUpperCaseLetter(password1)) {
			throw new UserPasswordException.MustHaveMoreUppercase(1);
		}

		if (!checkStringContainSpecialCharacter(password1)) {
			throw new UserPasswordException.MustHaveMoreSymbols(1);
		}

		if (!checkPasswordMatch(password1, password2)) {
			throw new UserPasswordException.MustMatch(userId);
		}

		if (!checkValueOfBirthday(birthdayDay, 31)) {
			throw new UserRegistrationValidationException.
				DayInBirthdayMustCorrect();
		}

		if (!checkValueOfBirthday(birthdayMonth, 12)) {
			throw new UserRegistrationValidationException.
				MonthInBirthdayMustCorrect();
		}

		if (!checkCurrentDateTime(birthdayDay, birthdayMonth, birthdayYear)) {
			throw new UserRegistrationValidationException.
				BirthdayMustNotInFuture();
		}

		if (!checkOldWithCurrentYear(
				birthdayDay, birthdayMonth, birthdayYear)) {

			throw new UserRegistrationValidationException.
				BirthdayMustNotSmaller13();
		}
	}

	@Override
	public void validateReminderQuery(
			long userId, String question, String answer)
		throws UserRegistrationReminderQueryException {

		if (!checkNull(question)) {
			throw new UserRegistrationReminderQueryException.
				SecurityQuestionMustNotBeNull();
		}

		if (!checkNull(answer)) {
			throw new UserRegistrationReminderQueryException.
				AnswerMustNotBeNull();
		}

		if (!checkMaxLength(answer, 255)) {
			throw new UserRegistrationReminderQueryException.
				AnswerMustBeShorter(255);
		}
	}

	@Override
	public void validateUserCustom(
			long userId, String homePhone, String mobilePhone)
		throws UserCustomRegistrationValidationException {

		if (!checkLength(homePhone, 10)) {
			throw new UserCustomRegistrationValidationException.
				HomePhoneMustBe10Digits();
		}

		if (!checkLength(mobilePhone, 10)) {
			throw new UserCustomRegistrationValidationException.
				MobilePhoneMustBe10Digits();
		}

		if (!checkStringContainOnlyNumber(homePhone)) {
			throw new UserCustomRegistrationValidationException.
				HomePhoneMustBe10Digits();
		}

		if (!checkStringContainOnlyNumber(mobilePhone)) {
			throw new UserCustomRegistrationValidationException.
				HomePhoneMustBe10Digits();
		}
	}

	private boolean checkCurrentDateTime(int day, int month, int year) {
		boolean result = true;

		LocalDate birthDate = LocalDate.of(year, month, day);

		LocalDate today = LocalDate.now();

		if (today.isBefore(birthDate)) {
			result = false;
		}

		return result;
	}

	private boolean checkLength(String string, int number) {
		boolean result = true;

		if (string.length() < number) {
			result = false;
		}

		return result;
	}

	private boolean checkMaxLength(String stringName, int maxLength) {
		boolean result = true;

		if (stringName.length() > maxLength) {
			result = false;
		}

		return result;
	}

	private boolean checkMinLength(String stringName, int minLength) {
		boolean result = true;

		if (stringName.length() < minLength) {
			result = false;
		}

		return result;
	}

	private boolean checkNull(String stringName) {
		boolean result = true;

		if (Validator.isBlank(stringName)) {
			result = false;
		}

		return result;
	}

	private boolean checkOldWithCurrentYear(int day, int month, int year) {
		boolean result = true;

		LocalDate birthDate = LocalDate.of(year, month, day);

		LocalDate today = LocalDate.now();

		Period period = Period.between(birthDate, today);

		int old = period.getYears();

		if (old < 13) {
			result = false;
		}

		return result;
	}

	private boolean checkPasswordMatch(String password1, String password2) {
		boolean result = true;

		if (!password1.equals(password2)) {
			result = false;
		}

		return result;
	}

	private boolean checkStringContainNumber(String stringName) {
		boolean result = true;

		char[] charArray = stringName.toCharArray();

		int count = 0;

		for (int i = 0; i < charArray.length; i++) {

			// if any character is number, return true

			if (Character.isDigit(charArray[i])) {
				count++;
			}
		}

		if (count == 0) {
			result = false;
		}

		return result;
	}

	private boolean checkStringContainOnlyNumber(String stringName) {
		boolean result = true;

		char[] charArray = stringName.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			// if any character is not number, return false

			if (!Character.isDigit(charArray[i])) {
				result = false;
			}
		}

		return result;
	}

	private boolean checkStringContainSpecialCharacter(String stringName) {
		boolean result = true;

		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

		Matcher matcher = pattern.matcher(stringName);

		boolean isStringContainsSpecialCharacter = matcher.find();

		if (!isStringContainsSpecialCharacter) {
			result = false;
		}

		return result;
	}

	private boolean checkStringContainUpperCaseLetter(String stringName) {
		boolean result = true;

		char[] charArray = stringName.toCharArray();

		int count = 0;

		for (int i = 0; i < charArray.length; i++) {

			// if any character is in upper case, return true

			if (Character.isUpperCase(charArray[i])) {
				count++;
			}
		}

		if (count == 0) {
			result = false;
		}

		return result;
	}

	private boolean checkValueOfBirthday(int value, int realValue) {
		boolean result = true;

		if ((0 > value) || (value > realValue)) {
			result = false;
		}

		return result;
	}

}