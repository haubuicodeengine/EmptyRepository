package com.liferay.overriding.services;

import com.liferay.amf.registration.validator.AddressValidator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.service.AddressLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class AddressLocalServiceOverride extends AddressLocalServiceWrapper {

	public AddressLocalServiceOverride() {
		super(null);
	}

	@Override
	public Address addAddress(
			long userId, String className, long classPK, String street1,
			String street2, String street3, String city, String zip,
			long regionId, long countryId, long typeId, boolean mailing,
			boolean primary, ServiceContext serviceContext)
		throws PortalException {

		_addressValidator.validateAddress(street1, street2, city, zip);

		return super.addAddress(
			userId, className, classPK, street1, street2, street3, city, zip,
			regionId, countryId, typeId, mailing, primary, serviceContext);
	}

	@Reference
	AddressValidator _addressValidator;

}