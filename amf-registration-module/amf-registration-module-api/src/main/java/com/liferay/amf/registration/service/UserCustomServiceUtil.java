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

package com.liferay.amf.registration.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for UserCustom. This utility wraps
 * <code>com.liferay.amf.registration.service.impl.UserCustomServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomService
 * @generated
 */
public class UserCustomServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.registration.service.impl.UserCustomServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.amf.registration.model.UserCustom addUserCustom(
			long groupId, long userId, boolean male, String homePhone,
			String mobilePhone,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addUserCustom(
			groupId, userId, male, homePhone, mobilePhone, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserCustomService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserCustomService, UserCustomService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserCustomService.class);

		ServiceTracker<UserCustomService, UserCustomService> serviceTracker =
			new ServiceTracker<UserCustomService, UserCustomService>(
				bundle.getBundleContext(), UserCustomService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}