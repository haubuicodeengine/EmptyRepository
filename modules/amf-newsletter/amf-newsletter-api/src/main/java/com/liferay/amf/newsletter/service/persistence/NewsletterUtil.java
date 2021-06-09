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

package com.liferay.amf.newsletter.service.persistence;

import com.liferay.amf.newsletter.model.Newsletter;
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
 * The persistence utility for the newsletter service. This utility wraps <code>com.liferay.amf.newsletter.service.persistence.impl.NewsletterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @generated
 */
public class NewsletterUtil {

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
	public static void clearCache(Newsletter newsletter) {
		getPersistence().clearCache(newsletter);
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
	public static Map<Serializable, Newsletter> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Newsletter update(Newsletter newsletter) {
		return getPersistence().update(newsletter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Newsletter update(
		Newsletter newsletter, ServiceContext serviceContext) {

		return getPersistence().update(newsletter, serviceContext);
	}

	/**
	 * Returns all the newsletters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletters
	 */
	public static List<Newsletter> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	public static List<Newsletter> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByUuid_First(
			String uuid, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUuid_First(
		String uuid, OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByUuid_Last(
			String uuid, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUuid_Last(
		String uuid, OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param resourcePrimKey the primary key of the current newsletter
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public static Newsletter[] findByUuid_PrevAndNext(
			long resourcePrimKey, String uuid,
			OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_PrevAndNext(
			resourcePrimKey, uuid, orderByComparator);
	}

	/**
	 * Removes all the newsletters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of newsletters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletters
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the newsletter where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNewsletterException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByUUID_G(String uuid, long groupId)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the newsletter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the newsletter where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the newsletter that was removed
	 */
	public static Newsletter removeByUUID_G(String uuid, long groupId)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of newsletters where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching newsletters
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the newsletters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching newsletters
	 */
	public static List<Newsletter> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the newsletters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	public static List<Newsletter> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first newsletter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourcePrimKey the primary key of the current newsletter
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public static Newsletter[] findByUuid_C_PrevAndNext(
			long resourcePrimKey, String uuid, long companyId,
			OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByUuid_C_PrevAndNext(
			resourcePrimKey, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the newsletters where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of newsletters where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching newsletters
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the newsletters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching newsletters
	 */
	public static List<Newsletter> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the newsletters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	public static List<Newsletter> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the newsletters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletters where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching newsletters
	 */
	public static List<Newsletter> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first newsletter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByGroupId_First(
			long groupId, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first newsletter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByGroupId_First(
		long groupId, OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	public static Newsletter findByGroupId_Last(
			long groupId, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last newsletter in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static Newsletter fetchByGroupId_Last(
		long groupId, OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where groupId = &#63;.
	 *
	 * @param resourcePrimKey the primary key of the current newsletter
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public static Newsletter[] findByGroupId_PrevAndNext(
			long resourcePrimKey, long groupId,
			OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByGroupId_PrevAndNext(
			resourcePrimKey, groupId, orderByComparator);
	}

	/**
	 * Removes all the newsletters where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of newsletters where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching newsletters
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the newsletter in the entity cache if it is enabled.
	 *
	 * @param newsletter the newsletter
	 */
	public static void cacheResult(Newsletter newsletter) {
		getPersistence().cacheResult(newsletter);
	}

	/**
	 * Caches the newsletters in the entity cache if it is enabled.
	 *
	 * @param newsletters the newsletters
	 */
	public static void cacheResult(List<Newsletter> newsletters) {
		getPersistence().cacheResult(newsletters);
	}

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param resourcePrimKey the primary key for the new newsletter
	 * @return the new newsletter
	 */
	public static Newsletter create(long resourcePrimKey) {
		return getPersistence().create(resourcePrimKey);
	}

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourcePrimKey the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public static Newsletter remove(long resourcePrimKey)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().remove(resourcePrimKey);
	}

	public static Newsletter updateImpl(Newsletter newsletter) {
		return getPersistence().updateImpl(newsletter);
	}

	/**
	 * Returns the newsletter with the primary key or throws a <code>NoSuchNewsletterException</code> if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the newsletter
	 * @return the newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	public static Newsletter findByPrimaryKey(long resourcePrimKey)
		throws com.liferay.amf.newsletter.exception.NoSuchNewsletterException {

		return getPersistence().findByPrimaryKey(resourcePrimKey);
	}

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourcePrimKey the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 */
	public static Newsletter fetchByPrimaryKey(long resourcePrimKey) {
		return getPersistence().fetchByPrimaryKey(resourcePrimKey);
	}

	/**
	 * Returns all the newsletters.
	 *
	 * @return the newsletters
	 */
	public static List<Newsletter> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 */
	public static List<Newsletter> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletters
	 */
	public static List<Newsletter> findAll(
		int start, int end, OrderByComparator<Newsletter> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of newsletters
	 */
	public static List<Newsletter> findAll(
		int start, int end, OrderByComparator<Newsletter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the newsletters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NewsletterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NewsletterPersistence, NewsletterPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsletterPersistence.class);

		ServiceTracker<NewsletterPersistence, NewsletterPersistence>
			serviceTracker =
				new ServiceTracker
					<NewsletterPersistence, NewsletterPersistence>(
						bundle.getBundleContext(), NewsletterPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}