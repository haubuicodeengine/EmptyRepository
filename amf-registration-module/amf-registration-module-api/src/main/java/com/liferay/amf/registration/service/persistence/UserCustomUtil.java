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

package com.liferay.amf.registration.service.persistence;

import com.liferay.amf.registration.model.UserCustom;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the user custom service. This utility wraps <code>com.liferay.amf.registration.service.persistence.impl.UserCustomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomPersistence
 * @generated
 */
public class UserCustomUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserCustom userCustom) {
		getPersistence().clearCache(userCustom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserCustom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserCustom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserCustom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserCustom update(UserCustom userCustom) {
		return getPersistence().update(userCustom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserCustom update(
		UserCustom userCustom, ServiceContext serviceContext) {

		return getPersistence().update(userCustom, serviceContext);
	}

	/**
	 * Caches the user custom in the entity cache if it is enabled.
	 *
	 * @param userCustom the user custom
	 */
	public static void cacheResult(UserCustom userCustom) {
		getPersistence().cacheResult(userCustom);
	}

	/**
	 * Caches the user customs in the entity cache if it is enabled.
	 *
	 * @param userCustoms the user customs
	 */
	public static void cacheResult(List<UserCustom> userCustoms) {
		getPersistence().cacheResult(userCustoms);
	}

	/**
	 * Creates a new user custom with the primary key. Does not add the user custom to the database.
	 *
	 * @param userCustomId the primary key for the new user custom
	 * @return the new user custom
	 */
	public static UserCustom create(long userCustomId) {
		return getPersistence().create(userCustomId);
	}

	/**
	 * Removes the user custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom that was removed
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	public static UserCustom remove(long userCustomId)
		throws com.liferay.amf.registration.exception.
			NoSuchUserCustomException {

		return getPersistence().remove(userCustomId);
	}

	public static UserCustom updateImpl(UserCustom userCustom) {
		return getPersistence().updateImpl(userCustom);
	}

	/**
	 * Returns the user custom with the primary key or throws a <code>NoSuchUserCustomException</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	public static UserCustom findByPrimaryKey(long userCustomId)
		throws com.liferay.amf.registration.exception.
			NoSuchUserCustomException {

		return getPersistence().findByPrimaryKey(userCustomId);
	}

	/**
	 * Returns the user custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom, or <code>null</code> if a user custom with the primary key could not be found
	 */
	public static UserCustom fetchByPrimaryKey(long userCustomId) {
		return getPersistence().fetchByPrimaryKey(userCustomId);
	}

	/**
	 * Returns all the user customs.
	 *
	 * @return the user customs
	 */
	public static List<UserCustom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @return the range of user customs
	 */
	public static List<UserCustom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user customs
	 */
	public static List<UserCustom> findAll(
		int start, int end, OrderByComparator<UserCustom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user customs
	 */
	public static List<UserCustom> findAll(
		int start, int end, OrderByComparator<UserCustom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user customs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user customs.
	 *
	 * @return the number of user customs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserCustomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserCustomPersistence, UserCustomPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserCustomPersistence.class);

		ServiceTracker<UserCustomPersistence, UserCustomPersistence>
			serviceTracker =
				new ServiceTracker
					<UserCustomPersistence, UserCustomPersistence>(
						bundle.getBundleContext(), UserCustomPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}