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

package com.liferay.training.news.letter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for NewsLetter. This utility wraps
 * <code>com.liferay.training.news.letter.service.impl.NewsLetterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NewsLetterLocalService
 * @generated
 */
public class NewsLetterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.training.news.letter.service.impl.NewsLetterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the news letter to the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsLetter the news letter
	 * @return the news letter that was added
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
		addNewsLetter(
			com.liferay.training.news.letter.model.NewsLetter newsLetter) {

		return getService().addNewsLetter(newsLetter);
	}

	/**
	 * Creates a new news letter with the primary key. Does not add the news letter to the database.
	 *
	 * @param newsletterId the primary key for the new news letter
	 * @return the new news letter
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
		createNewsLetter(long newsletterId) {

		return getService().createNewsLetter(newsletterId);
	}

	/**
	 * Deletes the news letter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterId the primary key of the news letter
	 * @return the news letter that was removed
	 * @throws PortalException if a news letter with the primary key could not be found
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
			deleteNewsLetter(long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNewsLetter(newsletterId);
	}

	/**
	 * Deletes the news letter from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsLetter the news letter
	 * @return the news letter that was removed
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
		deleteNewsLetter(
			com.liferay.training.news.letter.model.NewsLetter newsLetter) {

		return getService().deleteNewsLetter(newsLetter);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.news.letter.model.impl.NewsLetterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.news.letter.model.impl.NewsLetterModelImpl</code>.
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

	public static com.liferay.training.news.letter.model.NewsLetter
		fetchNewsLetter(long newsletterId) {

		return getService().fetchNewsLetter(newsletterId);
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
	 * Returns the news letter with the primary key.
	 *
	 * @param newsletterId the primary key of the news letter
	 * @return the news letter
	 * @throws PortalException if a news letter with the primary key could not be found
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
			getNewsLetter(long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNewsLetter(newsletterId);
	}

	/**
	 * Returns a range of all the news letters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.training.news.letter.model.impl.NewsLetterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news letters
	 * @param end the upper bound of the range of news letters (not inclusive)
	 * @return the range of news letters
	 */
	public static java.util.List
		<com.liferay.training.news.letter.model.NewsLetter> getNewsLetters(
			int start, int end) {

		return getService().getNewsLetters(start, end);
	}

	/**
	 * Returns the number of news letters.
	 *
	 * @return the number of news letters
	 */
	public static int getNewsLettersCount() {
		return getService().getNewsLettersCount();
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
	 * Updates the news letter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param newsLetter the news letter
	 * @return the news letter that was updated
	 */
	public static com.liferay.training.news.letter.model.NewsLetter
		updateNewsLetter(
			com.liferay.training.news.letter.model.NewsLetter newsLetter) {

		return getService().updateNewsLetter(newsLetter);
	}

	public static NewsLetterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NewsLetterLocalService, NewsLetterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsLetterLocalService.class);

		ServiceTracker<NewsLetterLocalService, NewsLetterLocalService>
			serviceTracker =
				new ServiceTracker
					<NewsLetterLocalService, NewsLetterLocalService>(
						bundle.getBundleContext(), NewsLetterLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}