package com.liferay.amf.search.validator;

import com.liferay.amf.search.validator.exception.AmfSearchValidationException.ZipCodeMustBe5Digits;
import com.liferay.amf.search.validator.exception.AmfSearchValidationException.ZipCodeMustNotBeNull;

public interface AmfSearchValidation {

	public void validate(String zipcode) throws ZipCodeMustNotBeNull, ZipCodeMustBe5Digits;

}
