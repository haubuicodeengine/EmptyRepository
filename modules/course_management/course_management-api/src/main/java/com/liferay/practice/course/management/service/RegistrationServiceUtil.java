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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Registration. This utility wraps
 * <code>com.liferay.practice.course.management.service.impl.RegistrationServiceImpl</code>
 * and is an access point for service operations in application layer code
 * running on a remote server. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationService
 * @generated
 */
public class RegistrationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.liferay.practice.course.management.service.impl.
	 * RegistrationServiceImpl</code> and rerun ServiceBuilder to regenerate this
	 * class.
	 */
	public static com.liferay.practice.course.management.model.Registration deleteRegistration(long registrationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRegistration(registrationId);
	}

	public static java.util.List<Long> getListRegisteredCourseByUserId(long userId) {

		return getService().getListRegisteredCourseByUserId(userId);
	}

	public static java.util.List<com.liferay.practice.course.management.model.Registration> getListRegistration() {

		return getService().getListRegistration();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.practice.course.management.model.Registration registerCourse(long groupId, long courseId,
			int registerStatus, com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().registerCourse(groupId, courseId, registerStatus, serviceContext);
	}

	public static com.liferay.practice.course.management.model.Registration updateRegistrationStatus(
			long registrationId, int status) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateRegistrationStatus(registrationId, status);
	}

	public static RegistrationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistrationService, RegistrationService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistrationService.class);

		ServiceTracker<RegistrationService, RegistrationService> serviceTracker = new ServiceTracker<RegistrationService, RegistrationService>(
				bundle.getBundleContext(), RegistrationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}