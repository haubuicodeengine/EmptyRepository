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

package com.liferay.practice.course.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationService}.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceWrapper implements RegistrationService, ServiceWrapper<RegistrationService> {

	public RegistrationServiceWrapper(RegistrationService registrationService) {
		_registrationService = registrationService;
	}

	@Override
	public com.liferay.practice.course.management.model.Registration deleteRegistration(long registrationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.deleteRegistration(registrationId);
	}

	@Override
	public java.util.List<Long> getListRegisteredCourseByUserId(long userId) {
		return _registrationService.getListRegisteredCourseByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Registration> getListRegistration() {

		return _registrationService.getListRegistration();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _registrationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.practice.course.management.model.Registration registerCourse(long groupId, long courseId,
			int registerStatus, com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.registerCourse(groupId, courseId, registerStatus, serviceContext);
	}

	@Override
	public com.liferay.practice.course.management.model.Registration updateRegistrationStatus(long registrationId,
			int status) throws com.liferay.portal.kernel.exception.PortalException {

		return _registrationService.updateRegistrationStatus(registrationId, status);
	}

	@Override
	public RegistrationService getWrappedService() {
		return _registrationService;
	}

	@Override
	public void setWrappedService(RegistrationService registrationService) {
		_registrationService = registrationService;
	}

	private RegistrationService _registrationService;

}