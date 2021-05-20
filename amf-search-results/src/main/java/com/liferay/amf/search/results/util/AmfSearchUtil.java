package com.liferay.amf.search.results.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.AddressLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	service = AmfSearchUtil.class, 
	immediate = true
)
public class AmfSearchUtil {

	public List<Address> getAddressByZipCode(String zipCode, boolean primary) {

		Order order = OrderFactoryUtil.desc("createDate");

		DynamicQuery addressQuery = _addressLocalService.dynamicQuery().add(RestrictionsFactoryUtil.eq("zip", zipCode))
				.add(RestrictionsFactoryUtil.eq("primary", primary)).addOrder(order);

		return _addressLocalService.dynamicQuery(addressQuery);
	}

	public List<User> getUsersByaddresss(List<Address> addresssList) throws PortalException {

		List<User> users = new ArrayList<User>();

		for (Address address : addresssList) {

			Contact contact = _contactLocalService.getContact(address.getClassPK());

			users.add(_userLocalService.getUserByEmailAddress(contact.getCompanyId(), contact.getEmailAddress()));
		}

		return users;
	}

	@Reference
	private AddressLocalService _addressLocalService;

	@Reference
	private ContactLocalService _contactLocalService;

	@Reference
	private UserLocalService _userLocalService;

}
