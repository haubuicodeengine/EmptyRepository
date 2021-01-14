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
 * Provides a wrapper for {@link CustomUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserLocalService
 * @generated
 */
public class CustomUserLocalServiceWrapper
	implements CustomUserLocalService, ServiceWrapper<CustomUserLocalService> {

	public CustomUserLocalServiceWrapper(
		CustomUserLocalService customUserLocalService) {

		_customUserLocalService = customUserLocalService;
	}

	/**
	 * Adds the custom user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param customUser the custom user
	 * @return the custom user that was added
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser addCustomUser(
		com.liferay.amf.registration.model.CustomUser customUser) {

		return _customUserLocalService.addCustomUser(customUser);
	}

	/**
	 * Creates a new custom user with the primary key. Does not add the custom user to the database.
	 *
	 * @param customUserId the primary key for the new custom user
	 * @return the new custom user
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser createCustomUser(
		long customUserId) {

		return _customUserLocalService.createCustomUser(customUserId);
	}

	/**
	 * Deletes the custom user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customUser the custom user
	 * @return the custom user that was removed
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser deleteCustomUser(
		com.liferay.amf.registration.model.CustomUser customUser) {

		return _customUserLocalService.deleteCustomUser(customUser);
	}

	/**
	 * Deletes the custom user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customUserId the primary key of the custom user
	 * @return the custom user that was removed
	 * @throws PortalException if a custom user with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser deleteCustomUser(
			long customUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customUserLocalService.deleteCustomUser(customUserId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customUserLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customUserLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _customUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _customUserLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _customUserLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _customUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.amf.registration.model.CustomUser fetchCustomUser(
		long customUserId) {

		return _customUserLocalService.fetchCustomUser(customUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the custom user with the primary key.
	 *
	 * @param customUserId the primary key of the custom user
	 * @return the custom user
	 * @throws PortalException if a custom user with the primary key could not be found
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser getCustomUser(
			long customUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customUserLocalService.getCustomUser(customUserId);
	}

	/**
	 * Returns a range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.registration.model.impl.CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @return the range of custom users
	 */
	@Override
	public java.util.List<com.liferay.amf.registration.model.CustomUser>
		getCustomUsers(int start, int end) {

		return _customUserLocalService.getCustomUsers(start, end);
	}

	/**
	 * Returns the number of custom users.
	 *
	 * @return the number of custom users
	 */
	@Override
	public int getCustomUsersCount() {
		return _customUserLocalService.getCustomUsersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customUserLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the custom user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param customUser the custom user
	 * @return the custom user that was updated
	 */
	@Override
	public com.liferay.amf.registration.model.CustomUser updateCustomUser(
		com.liferay.amf.registration.model.CustomUser customUser) {

		return _customUserLocalService.updateCustomUser(customUser);
	}

	@Override
	public CustomUserLocalService getWrappedService() {
		return _customUserLocalService;
	}

	@Override
	public void setWrappedService(
		CustomUserLocalService customUserLocalService) {

		_customUserLocalService = customUserLocalService;
	}

	private CustomUserLocalService _customUserLocalService;

}