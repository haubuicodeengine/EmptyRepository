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
 * Provides the local service utility for UserCustom. This utility wraps
 * <code>com.liferay.amf.registration.service.impl.UserCustomLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomLocalService
 * @generated
 */
public class UserCustomLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.registration.service.impl.UserCustomLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	 * Adds the user custom to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustom the user custom
	 * @return the user custom that was added
	 */
	public static com.liferay.amf.registration.model.UserCustom addUserCustom(
		com.liferay.amf.registration.model.UserCustom userCustom) {

		return getService().addUserCustom(userCustom);
	}

	/**
	 * Creates a new user custom with the primary key. Does not add the user custom to the database.
	 *
	 * @param userCustomId the primary key for the new user custom
	 * @return the new user custom
	 */
	public static com.liferay.amf.registration.model.UserCustom
		createUserCustom(long userCustomId) {

		return getService().createUserCustom(userCustomId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom that was removed
	 * @throws PortalException if a user custom with the primary key could not be found
	 */
	public static com.liferay.amf.registration.model.UserCustom
			deleteUserCustom(long userCustomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserCustom(userCustomId);
	}

	/**
	 * Deletes the user custom from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustom the user custom
	 * @return the user custom that was removed
	 */
	public static com.liferay.amf.registration.model.UserCustom
		deleteUserCustom(
			com.liferay.amf.registration.model.UserCustom userCustom) {

		return getService().deleteUserCustom(userCustom);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.amf.registration.model.UserCustom fetchUserCustom(
		long userCustomId) {

		return getService().fetchUserCustom(userCustomId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user custom with the primary key.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom
	 * @throws PortalException if a user custom with the primary key could not be found
	 */
	public static com.liferay.amf.registration.model.UserCustom getUserCustom(
			long userCustomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserCustom(userCustomId);
	}

	/**
	 * Returns a range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @return the range of user customs
	 */
	public static java.util.List<com.liferay.amf.registration.model.UserCustom>
		getUserCustoms(int start, int end) {

		return getService().getUserCustoms(start, end);
	}

	/**
	 * Returns the number of user customs.
	 *
	 * @return the number of user customs
	 */
	public static int getUserCustomsCount() {
		return getService().getUserCustomsCount();
	}

	/**
	 * Updates the user custom in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userCustom the user custom
	 * @return the user custom that was updated
	 */
	public static com.liferay.amf.registration.model.UserCustom
		updateUserCustom(
			com.liferay.amf.registration.model.UserCustom userCustom) {

		return getService().updateUserCustom(userCustom);
	}

	public static UserCustomLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserCustomLocalService, UserCustomLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserCustomLocalService.class);

		ServiceTracker<UserCustomLocalService, UserCustomLocalService>
			serviceTracker =
				new ServiceTracker
					<UserCustomLocalService, UserCustomLocalService>(
						bundle.getBundleContext(), UserCustomLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}