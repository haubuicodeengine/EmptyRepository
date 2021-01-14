package com.liferay.amf.registration.service.impl;

import com.liferay.amf.registration.model.UserCustom;
import com.liferay.amf.registration.service.base.UserCustomServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"json.web.service.context.name=amf_registration",
		"json.web.service.context.path=UserCustom"
	},
	service = AopService.class
)
public class UserCustomServiceImpl extends UserCustomServiceBaseImpl {

	public UserCustom addUserCustom(
			long groupId, long userId, boolean male, String homePhone,
			String mobilePhone, ServiceContext serviceContext)
		throws PortalException {

		return userCustomLocalService.addUserCustom(
			groupId, userId, male, homePhone, mobilePhone, serviceContext);
	}

}