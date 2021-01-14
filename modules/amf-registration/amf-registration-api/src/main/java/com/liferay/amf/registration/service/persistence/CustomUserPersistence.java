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

import com.liferay.amf.registration.exception.NoSuchCustomUserException;
import com.liferay.amf.registration.model.CustomUser;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the custom user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomUserUtil
 * @generated
 */
@ProviderType
public interface CustomUserPersistence extends BasePersistence<CustomUser> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CustomUserUtil} to access the custom user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the custom users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching custom users
	 */
	public java.util.List<CustomUser> findByGroupId(long groupId);

	/**
	 * Returns a range of all the custom users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @return the range of matching custom users
	 */
	public java.util.List<CustomUser> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the custom users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching custom users
	 */
	public java.util.List<CustomUser> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the custom users where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching custom users
	 */
	public java.util.List<CustomUser> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first custom user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom user
	 * @throws NoSuchCustomUserException if a matching custom user could not be found
	 */
	public CustomUser findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Returns the first custom user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching custom user, or <code>null</code> if a matching custom user could not be found
	 */
	public CustomUser fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns the last custom user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom user
	 * @throws NoSuchCustomUserException if a matching custom user could not be found
	 */
	public CustomUser findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Returns the last custom user in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching custom user, or <code>null</code> if a matching custom user could not be found
	 */
	public CustomUser fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns the custom users before and after the current custom user in the ordered set where groupId = &#63;.
	 *
	 * @param customUserId the primary key of the current custom user
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next custom user
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser[] findByGroupId_PrevAndNext(
			long customUserId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
				orderByComparator)
		throws NoSuchCustomUserException;

	/**
	 * Removes all the custom users where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of custom users where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching custom users
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the custom user in the entity cache if it is enabled.
	 *
	 * @param customUser the custom user
	 */
	public void cacheResult(CustomUser customUser);

	/**
	 * Caches the custom users in the entity cache if it is enabled.
	 *
	 * @param customUsers the custom users
	 */
	public void cacheResult(java.util.List<CustomUser> customUsers);

	/**
	 * Creates a new custom user with the primary key. Does not add the custom user to the database.
	 *
	 * @param customUserId the primary key for the new custom user
	 * @return the new custom user
	 */
	public CustomUser create(long customUserId);

	/**
	 * Removes the custom user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param customUserId the primary key of the custom user
	 * @return the custom user that was removed
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser remove(long customUserId)
		throws NoSuchCustomUserException;

	public CustomUser updateImpl(CustomUser customUser);

	/**
	 * Returns the custom user with the primary key or throws a <code>NoSuchCustomUserException</code> if it could not be found.
	 *
	 * @param customUserId the primary key of the custom user
	 * @return the custom user
	 * @throws NoSuchCustomUserException if a custom user with the primary key could not be found
	 */
	public CustomUser findByPrimaryKey(long customUserId)
		throws NoSuchCustomUserException;

	/**
	 * Returns the custom user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param customUserId the primary key of the custom user
	 * @return the custom user, or <code>null</code> if a custom user with the primary key could not be found
	 */
	public CustomUser fetchByPrimaryKey(long customUserId);

	/**
	 * Returns all the custom users.
	 *
	 * @return the custom users
	 */
	public java.util.List<CustomUser> findAll();

	/**
	 * Returns a range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @return the range of custom users
	 */
	public java.util.List<CustomUser> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of custom users
	 */
	public java.util.List<CustomUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator);

	/**
	 * Returns an ordered range of all the custom users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of custom users
	 * @param end the upper bound of the range of custom users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of custom users
	 */
	public java.util.List<CustomUser> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CustomUser>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the custom users from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of custom users.
	 *
	 * @return the number of custom users
	 */
	public int countAll();

}