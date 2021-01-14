package com.liferay.amf.registration.service.impl;

import com.liferay.amf.registration.model.UserCustom;
import com.liferay.amf.registration.service.base.UserCustomLocalServiceBaseImpl;
import com.liferay.amf.registration.validator.UserRegistrationValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "model.class.name=com.liferay.amf.registration.model.UserCustom",
	service = AopService.class
)
public class UserCustomLocalServiceImpl extends UserCustomLocalServiceBaseImpl {

	public UserCustom addUserCustom(
			long groupId, long userId, boolean male, String homePhone,
			String mobilePhone, ServiceContext serviceContext)
		throws PortalException {

		_userRegistrationValidator.validateUserCustom(
			userId, homePhone, mobilePhone);

		User user = userLocalService.getUser(userId);

		Group group = groupLocalService.getGroup(groupId);

		long userCustomId = counterLocalService.increment(
			UserCustom.class.getName());

		UserCustom userCustom = createUserCustom(userCustomId);

		userCustom.setCompanyId(group.getCompanyId());
		userCustom.setGroupId(groupId);
		userCustom.setUserId(user.getUserId());
		userCustom.setUserName(user.getFullName());
		userCustom.setHomePhone(homePhone);
		userCustom.setMobilePhone(mobilePhone);
		userCustom.setCreateDate(serviceContext.getCreateDate(new Date()));
		userCustom.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		return super.addUserCustom(userCustom);
	}

	@Override
	public UserCustom addUserCustom(UserCustom userCustom) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Reference
	GroupLocalService groupLocalService;

	@Reference
	UserRegistrationValidator _userRegistrationValidator;

}