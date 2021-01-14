package com.liferay.amf.registration.validator.impl;

import com.liferay.amf.registration.exception.AddressValidationException;
import com.liferay.amf.registration.validator.AddressValidator;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	service = AddressValidator.class
)
public class AddressValidatotImpl implements AddressValidator {

	@Override
	public void validateAddress(
			String street1, String street2, String city, String zip)
		throws AddressValidationException {

		if (!checkNull(street1)) {
			throw new AddressValidationException.AddressMustNotBeNull();
		}

		if (!checkNull(city)) {
			throw new AddressValidationException.CityMustNotBeNull();
		}

		if (!checkNull(zip)) {
			throw new AddressValidationException.ZipCodeMustNotBeNull();
		}

		if (!checkMaxLength(street1, 255)) {
			throw new AddressValidationException.AddressMustBeShorter(255);
		}

		if (!checkMaxLength(city, 255)) {
			throw new AddressValidationException.AddressMustBeShorter(255);
		}

		if (!checkLength(zip, 5)) {
			throw new AddressValidationException.ZipCodeMustBe5Digits();
		}

		if (!checkStringContainOnlyNumber(zip)) {
			throw new AddressValidationException.ZipCodeMustBe5Digits();
		}
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

	private boolean checkNull(String stringName) {
		boolean result = true;

		if (Validator.isBlank(stringName)) {
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

}