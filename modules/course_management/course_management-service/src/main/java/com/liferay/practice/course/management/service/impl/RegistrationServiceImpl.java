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

package com.liferay.practice.course.management.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.service.base.RegistrationServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the registration remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.practice.course.management.service.RegistrationService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=coursemanagement",
		"json.web.service.context.path=Registration" }, service = AopService.class)
public class RegistrationServiceImpl extends RegistrationServiceBaseImpl {

	@Override
	public Registration registerCourse(long groupId, long courseId, int registerStatus, ServiceContext serviceContext)
			throws PortalException {

		return registrationLocalService.registerCourse(groupId, courseId, registerStatus, serviceContext);
	}

	@Override
	public List<Long> getListRegisteredCourseByUserId(long userId) {

		return registrationLocalService.getListRegisteredCourseByUserId(userId);
	}

	@Override
	public List<Registration> getListRegistration() {

		return registrationLocalService.getListRegistration();
	}

	@Override
	public Registration updateRegistrationStatus(long registrationId, int status) throws PortalException {

		return registrationLocalService.updateRegistrationStatus(registrationId, status);
	}

	@Override
	public Registration deleteRegistration(long registrationId) throws PortalException {

		return registrationLocalService.deleteRegistration(registrationId);
	}
}