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

package com.liferay.practice.course.management.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.practice.course.management.model.Registration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the registration service. This utility wraps
 * <code>com.liferay.practice.course.management.service.persistence.impl.RegistrationPersistenceImpl</code>
 * and provides direct access to the database for CRUD operations. This utility
 * should only be used by the service layer, as it must operate within a
 * transaction. Never access this utility in a JSP, controller, model, or other
 * front-end class.
 *
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationPersistence
 * @generated
 */
public class RegistrationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun
	 * ServiceBuilder to regenerate this class.
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
	public static void clearCache(Registration registration) {
		getPersistence().clearCache(registration);
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
	public static Map<Serializable, Registration> fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Registration> findWithDynamicQuery(DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery,
	 *      int, int)
	 */
	public static List<Registration> findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery,
	 *      int, int, OrderByComparator)
	 */
	public static List<Registration> findWithDynamicQuery(DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<Registration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Registration update(Registration registration) {
		return getPersistence().update(registration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel,
	 *      ServiceContext)
	 */
	public static Registration update(Registration registration, ServiceContext serviceContext) {

		return getPersistence().update(registration, serviceContext);
	}

	/**
	 * Returns all the registrations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching registrations
	 */
	public static List<Registration> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start   the lower bound of the range of registrations
	 * @param end     the upper bound of the range of registrations (not inclusive)
	 * @return the range of matching registrations
	 */
	public static List<Registration> findByGroupId(long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId           the group ID
	 * @param start             the lower bound of the range of registrations
	 * @param end               the upper bound of the range of registrations (not
	 *                          inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally
	 *                          <code>null</code>)
	 * @return the ordered range of matching registrations
	 */
	public static List<Registration> findByGroupId(long groupId, int start, int end,
			OrderByComparator<Registration> orderByComparator) {

		return getPersistence().findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registrations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId           the group ID
	 * @param start             the lower bound of the range of registrations
	 * @param end               the upper bound of the range of registrations (not
	 *                          inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally
	 *                          <code>null</code>)
	 * @param useFinderCache    whether to use the finder cache
	 * @return the ordered range of matching registrations
	 */
	public static List<Registration> findByGroupId(long groupId, int start, int end,
			OrderByComparator<Registration> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId           the group ID
	 * @param orderByComparator the comparator to order the set by (optionally
	 *                          <code>null</code>)
	 * @return the first matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be
	 *                                     found
	 */
	public static Registration findByGroupId_First(long groupId, OrderByComparator<Registration> orderByComparator)
			throws com.liferay.practice.course.management.exception.NoSuchRegistrationException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId           the group ID
	 * @param orderByComparator the comparator to order the set by (optionally
	 *                          <code>null</code>)
	 * @return the first matching registration, or <code>null</code> if a matching
	 *         registration could not be found
	 */
	public static Registration fetchByGroupId_First(long groupId, OrderByComparator<Registration> orderByComparator) {

		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the last registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId           the group ID
	 * @param orderByComparator the comparator to order the set by (optionally
	 *                          <code>null</code>)
	 * @return the last matching registration
	 * @throws NoSuchRegistrationException if a matching registration could not be
	 *                                     found
	 */
	public static Registration findByGroupId_Last(long groupId, OrderByComparator<Registration> orderByComparator)
			throws com.liferay.practice.course.management.exception.NoSuchRegistrationException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last registration in the ordered set where groupId = &#63;.
	 *
	 * @param groupId           the group ID
	 * @param orderByComparator the comparator to order the set by (optionally
	 *                          <code>null</code>)
	 * @return the last matching registration, or <code>null</code> if a matching
	 *         registration could not be found
	 */
	public static Registration fetchByGroupId_Last(long groupId, OrderByComparator<Registration> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the registrations before and after the current registration in the
	 * ordered set where groupId = &#63;.
	 *
	 * @param registrationId    the primary key of the current registration
	 * @param groupId           the group ID
	 * @param orderByComparator the comparator to order the set by (optionally
	 *                          <code>null</code>)
	 * @return the previous, current, and next registration
	 * @throws NoSuchRegistrationException if a registration with the primary key
	 *                                     could not be found
	 */
	public static Registration[] findByGroupId_PrevAndNext(long registrationId, long groupId,
			OrderByComparator<Registration> orderByComparator)
			throws com.liferay.practice.course.management.exception.NoSuchRegistrationException {

		return getPersistence().findByGroupId_PrevAndNext(registrationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the registrations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of registrations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching registrations
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the registration in the entity cache if it is enabled.
	 *
	 * @param registration the registration
	 */
	public static void cacheResult(Registration registration) {
		getPersistence().cacheResult(registration);
	}

	/**
	 * Caches the registrations in the entity cache if it is enabled.
	 *
	 * @param registrations the registrations
	 */
	public static void cacheResult(List<Registration> registrations) {
		getPersistence().cacheResult(registrations);
	}

	/**
	 * Creates a new registration with the primary key. Does not add the
	 * registration to the database.
	 *
	 * @param registrationId the primary key for the new registration
	 * @return the new registration
	 */
	public static Registration create(long registrationId) {
		return getPersistence().create(registrationId);
	}

	/**
	 * Removes the registration with the primary key from the database. Also
	 * notifies the appropriate model listeners.
	 *
	 * @param registrationId the primary key of the registration
	 * @return the registration that was removed
	 * @throws NoSuchRegistrationException if a registration with the primary key
	 *                                     could not be found
	 */
	public static Registration remove(long registrationId)
			throws com.liferay.practice.course.management.exception.NoSuchRegistrationException {

		return getPersistence().remove(registrationId);
	}

	public static Registration updateImpl(Registration registration) {
		return getPersistence().updateImpl(registration);
	}

	/**
	 * Returns the registration with the primary key or throws a
	 * <code>NoSuchRegistrationException</code> if it could not be found.
	 *
	 * @param registrationId the primary key of the registration
	 * @return the registration
	 * @throws NoSuchRegistrationException if a registration with the primary key
	 *                                     could not be found
	 */
	public static Registration findByPrimaryKey(long registrationId)
			throws com.liferay.practice.course.management.exception.NoSuchRegistrationException {

		return getPersistence().findByPrimaryKey(registrationId);
	}

	/**
	 * Returns the registration with the primary key or returns <code>null</code> if
	 * it could not be found.
	 *
	 * @param registrationId the primary key of the registration
	 * @return the registration, or <code>null</code> if a registration with the
	 *         primary key could not be found
	 */
	public static Registration fetchByPrimaryKey(long registrationId) {
		return getPersistence().fetchByPrimaryKey(registrationId);
	}

	/**
	 * Returns all the registrations.
	 *
	 * @return the registrations
	 */
	public static List<Registration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of registrations
	 * @param end   the upper bound of the range of registrations (not inclusive)
	 * @return the range of registrations
	 */
	public static List<Registration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start             the lower bound of the range of registrations
	 * @param end               the upper bound of the range of registrations (not
	 *                          inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally
	 *                          <code>null</code>)
	 * @return the ordered range of registrations
	 */
	public static List<Registration> findAll(int start, int end, OrderByComparator<Registration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the registrations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code>
	 * instances. <code>start</code> and <code>end</code> are not primary keys, they
	 * are indexes in the result set. Thus, <code>0</code> refers to the first
	 * result in the set. Setting both <code>start</code> and <code>end</code> to
	 * <code>QueryUtil#ALL_POS</code> will return the full result set. If
	 * <code>orderByComparator</code> is specified, then the query will include the
	 * given ORDER BY logic. If <code>orderByComparator</code> is absent, then the
	 * query will include the default ORDER BY logic from
	 * <code>RegistrationModelImpl</code>.
	 * </p>
	 *
	 * @param start             the lower bound of the range of registrations
	 * @param end               the upper bound of the range of registrations (not
	 *                          inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally
	 *                          <code>null</code>)
	 * @param useFinderCache    whether to use the finder cache
	 * @return the ordered range of registrations
	 */
	public static List<Registration> findAll(int start, int end, OrderByComparator<Registration> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findAll(start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the registrations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of registrations.
	 *
	 * @return the number of registrations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RegistrationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistrationPersistence, RegistrationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistrationPersistence.class);

		ServiceTracker<RegistrationPersistence, RegistrationPersistence> serviceTracker = new ServiceTracker<RegistrationPersistence, RegistrationPersistence>(
				bundle.getBundleContext(), RegistrationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}