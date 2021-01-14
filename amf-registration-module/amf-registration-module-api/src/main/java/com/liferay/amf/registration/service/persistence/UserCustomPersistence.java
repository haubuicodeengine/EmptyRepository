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

import com.liferay.amf.registration.exception.NoSuchUserCustomException;
import com.liferay.amf.registration.model.UserCustom;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserCustomUtil
 * @generated
 */
@ProviderType
public interface UserCustomPersistence extends BasePersistence<UserCustom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserCustomUtil} to access the user custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the user custom in the entity cache if it is enabled.
	 *
	 * @param userCustom the user custom
	 */
	public void cacheResult(UserCustom userCustom);

	/**
	 * Caches the user customs in the entity cache if it is enabled.
	 *
	 * @param userCustoms the user customs
	 */
	public void cacheResult(java.util.List<UserCustom> userCustoms);

	/**
	 * Creates a new user custom with the primary key. Does not add the user custom to the database.
	 *
	 * @param userCustomId the primary key for the new user custom
	 * @return the new user custom
	 */
	public UserCustom create(long userCustomId);

	/**
	 * Removes the user custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom that was removed
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	public UserCustom remove(long userCustomId)
		throws NoSuchUserCustomException;

	public UserCustom updateImpl(UserCustom userCustom);

	/**
	 * Returns the user custom with the primary key or throws a <code>NoSuchUserCustomException</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	public UserCustom findByPrimaryKey(long userCustomId)
		throws NoSuchUserCustomException;

	/**
	 * Returns the user custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom, or <code>null</code> if a user custom with the primary key could not be found
	 */
	public UserCustom fetchByPrimaryKey(long userCustomId);

	/**
	 * Returns all the user customs.
	 *
	 * @return the user customs
	 */
	public java.util.List<UserCustom> findAll();

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
	public java.util.List<UserCustom> findAll(int start, int end);

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
	public java.util.List<UserCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCustom>
			orderByComparator);

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
	public java.util.List<UserCustom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserCustom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user customs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user customs.
	 *
	 * @return the number of user customs
	 */
	public int countAll();

}