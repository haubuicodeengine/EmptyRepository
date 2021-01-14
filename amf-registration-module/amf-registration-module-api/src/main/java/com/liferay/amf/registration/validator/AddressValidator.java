package com.liferay.amf.registration.validator;

import com.liferay.amf.registration.exception.AddressValidationException;

public interface AddressValidator {

	public void validateAddress(
			String street1, String street2, String city, String zip)
		throws AddressValidationException;

}