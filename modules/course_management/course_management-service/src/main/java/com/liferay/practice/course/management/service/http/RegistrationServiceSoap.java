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

package com.liferay.practice.course.management.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.practice.course.management.service.RegistrationServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the <code>RegistrationServiceUtil</code>
 * service utility. The static methods of this class call the same methods of
 * the service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.practice.course.management.model.RegistrationSoap</code>.
 * If the method in the service utility returns a
 * <code>com.liferay.practice.course.management.model.Registration</code>, that
 * is translated to a
 * <code>com.liferay.practice.course.management.model.RegistrationSoap</code>.
 * Methods that SOAP cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationServiceHttp
 * @generated
 */
public class RegistrationServiceSoap {

	public static com.liferay.practice.course.management.model.RegistrationSoap registerCourse(long groupId,
			long courseId, int registerStatus, com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws RemoteException {

		try {
			com.liferay.practice.course.management.model.Registration returnValue = RegistrationServiceUtil
					.registerCourse(groupId, courseId, registerStatus, serviceContext);

			return com.liferay.practice.course.management.model.RegistrationSoap.toSoapModel(returnValue);
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static Long[] getListRegisteredCourseByUserId(long userId) throws RemoteException {

		try {
			java.util.List<Long> returnValue = RegistrationServiceUtil.getListRegisteredCourseByUserId(userId);

			return returnValue.toArray(new Long[returnValue.size()]);
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.practice.course.management.model.RegistrationSoap[] getListRegistration()
			throws RemoteException {

		try {
			java.util.List<com.liferay.practice.course.management.model.Registration> returnValue = RegistrationServiceUtil
					.getListRegistration();

			return com.liferay.practice.course.management.model.RegistrationSoap.toSoapModels(returnValue);
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.practice.course.management.model.RegistrationSoap updateRegistrationStatus(
			long registrationId, int status) throws RemoteException {

		try {
			com.liferay.practice.course.management.model.Registration returnValue = RegistrationServiceUtil
					.updateRegistrationStatus(registrationId, status);

			return com.liferay.practice.course.management.model.RegistrationSoap.toSoapModel(returnValue);
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.practice.course.management.model.RegistrationSoap deleteRegistration(long registrationId)
			throws RemoteException {

		try {
			com.liferay.practice.course.management.model.Registration returnValue = RegistrationServiceUtil
					.deleteRegistration(registrationId);

			return com.liferay.practice.course.management.model.RegistrationSoap.toSoapModel(returnValue);
		} catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(RegistrationServiceSoap.class);

}