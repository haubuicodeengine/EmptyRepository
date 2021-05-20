package com.liferay.amf.search.validator.impl;

import com.liferay.amf.search.validator.AmfSearchValidation;
import com.liferay.amf.search.validator.exception.AmfSearchValidationException;
import com.liferay.amf.search.validator.exception.AmfSearchValidationException.ZipCodeMustBe5Digits;
import com.liferay.amf.search.validator.exception.AmfSearchValidationException.ZipCodeMustNotBeNull;
import com.liferay.portal.kernel.util.Validator;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	service = AmfSearchValidation.class
)
public class AmfSearchValidationImpl implements AmfSearchValidation {

	@Override
	public void validate(String zipcode) throws ZipCodeMustNotBeNull, ZipCodeMustBe5Digits {

		if (!_checkNull(zipcode)) {
			throw new AmfSearchValidationException.ZipCodeMustNotBeNull();
		}

		if (!_checkLength(zipcode, 5)) {
			throw new AmfSearchValidationException.ZipCodeMustBe5Digits();
		}

		if (!_checkStringContainOnlyNumber(zipcode)) {
			throw new AmfSearchValidationException.ZipCodeMustBe5Digits();
		}

	}

	private boolean _checkLength(String string, int number) {
		boolean result = true;

		if (string.length() != number) {
			result = false;
		}

		return result;
	}

	private boolean _checkNull(String stringName) {
		boolean result = true;

		if (Validator.isBlank(stringName)) {
			result = false;
		}

		return result;
	}

	private boolean _checkStringContainOnlyNumber(String stringName) {
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
