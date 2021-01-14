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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserCustomService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomService
 * @generated
 */
public class UserCustomServiceWrapper
	implements ServiceWrapper<UserCustomService>, UserCustomService {

	public UserCustomServiceWrapper(UserCustomService userCustomService) {
		_userCustomService = userCustomService;
	}

	@Override
	public com.liferay.amf.registration.model.UserCustom addUserCustom(
			long groupId, long userId, boolean male, String homePhone,
			String mobilePhone,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userCustomService.addUserCustom(
			groupId, userId, male, homePhone, mobilePhone, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userCustomService.getOSGiServiceIdentifier();
	}

	@Override
	public UserCustomService getWrappedService() {
		return _userCustomService;
	}

	@Override
	public void setWrappedService(UserCustomService userCustomService) {
		_userCustomService = userCustomService;
	}

	private UserCustomService _userCustomService;

}