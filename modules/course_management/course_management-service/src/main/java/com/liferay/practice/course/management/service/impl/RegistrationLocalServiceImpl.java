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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.service.RegistrationService;
import com.liferay.practice.course.management.service.base.RegistrationLocalServiceBaseImpl;
import com.liferay.practice.course.management.validator.RegistrationValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.practice.course.management.service.RegistrationLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.practice.course.management.model.Registration", service = AopService.class)
public class RegistrationLocalServiceImpl extends RegistrationLocalServiceBaseImpl {

	public Registration registerCourse(long groupId, long courseId, int registrationStatus,
			ServiceContext serviceContext) throws PortalException {

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		List<Registration> registrations = getListRegistration();

		_registrationValidator.validate(courseId, userId, registrations);

		long registrationId = counterLocalService.increment(Registration.class.getName());

		Registration registration = createRegistration(registrationId);

		registration.setCourseId(courseId);
		registration.setRegistrationStatus(registrationStatus);

		registration.setGroupId(groupId);
		registration.setCreateDate(serviceContext.getCreateDate(new Date()));
		registration.setUserId(userId);
		registration.setUserName(user.getScreenName());

		return super.addRegistration(registration);
	}

	@Override
	public List<Long> getListRegisteredCourseByUserId(long userId) {

		List<Long> registrations = new ArrayList<>();
		List<Registration> allRegistration = registrationPersistence.findAll();

		for (Registration registration : allRegistration) {

			if (registration.getUserId() == userId) {

				registrations.add(registration.getCourseId());
			}
		}

		return registrations;
	}

	@Override
	public List<Registration> getListRegistration() {

		return registrationPersistence.findAll();
	}

	@Override
	public Registration updateRegistrationStatus(long registrationId, int status) throws PortalException {

		Registration registration = getRegistration(registrationId);
		registration.setRegistrationStatus(status);

		registration = super.updateRegistration(registration);

		return registration;
	}

	@Reference
	RegistrationValidator _registrationValidator;

}