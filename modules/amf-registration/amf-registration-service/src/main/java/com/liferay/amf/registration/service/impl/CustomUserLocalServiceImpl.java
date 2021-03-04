/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.registration.service.impl;

import com.liferay.amf.registration.model.CustomUser;
import com.liferay.amf.registration.service.base.CustomUserLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the custom user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.amf.registration.service.CustomUserLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.amf.registration.model.CustomUser",
	service = AopService.class
)
public class CustomUserLocalServiceImpl extends CustomUserLocalServiceBaseImpl {

	@Override
	public CustomUser addCustomUser(long groupId, String home_phone, String mobile_phone, String state,
			String security_question, String security_answer, boolean accepted_tou, ServiceContext serviceContext)
			throws PortalException {
		
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		long customUserId = counterLocalService.increment(CustomUser.class.getName());
		
		CustomUser customUser = createCustomUser(customUserId);
		
		customUser.setCompanyId(group.getCompanyId());
		customUser.setCreateDate(serviceContext.getCreateDate(new Date()));
		customUser.setGroupId(groupId);
		customUser.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		customUser.setUserId(userId);
		customUser.setUserName(user.getScreenName());

		customUser.setHome_phone(home_phone);
		customUser.setMobile_phone(mobile_phone);
		customUser.setState(state);
		customUser.setSecurity_question(security_question);
		customUser.setSecurity_answer(security_answer);
		customUser.setAccepted_tou(accepted_tou);
		
		return super.addCustomUser(customUser);
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.amf.registration.service.CustomUserLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.amf.registration.service.CustomUserLocalServiceUtil</code>.
	 */
}