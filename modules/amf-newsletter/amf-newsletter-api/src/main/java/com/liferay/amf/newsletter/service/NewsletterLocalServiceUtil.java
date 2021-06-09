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

package com.liferay.amf.newsletter.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Newsletter. This utility wraps
 * <code>com.liferay.amf.newsletter.service.impl.NewsletterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterLocalService
 * @generated
 */
public class NewsletterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.amf.newsletter.service.impl.NewsletterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.amf.newsletter.model.Newsletter addNewsletter(
			long groupId, long resourcePrimKey, long issueNumber,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addNewsletter(
			groupId, resourcePrimKey, issueNumber, serviceContext);
	}

	/**
	 * Adds the newsletter to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was added
	 */
	public static com.liferay.amf.newsletter.model.Newsletter addNewsletter(
		com.liferay.amf.newsletter.model.Newsletter newsletter) {

		return getService().addNewsletter(newsletter);
	}

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param resourcePrimKey the primary key for the new newsletter
	 * @return the new newsletter
	 */
	public static com.liferay.amf.newsletter.model.Newsletter createNewsletter(
		long resourcePrimKey) {

		return getService().createNewsletter(resourcePrimKey);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourcePrimKey the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws PortalException if a newsletter with the primary key could not be found
	 */
	public static com.liferay.amf.newsletter.model.Newsletter deleteNewsletter(
			long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteNewsletter(resourcePrimKey);
	}

	/**
	 * Deletes the newsletter from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was removed
	 */
	public static com.liferay.amf.newsletter.model.Newsletter deleteNewsletter(
		com.liferay.amf.newsletter.model.Newsletter newsletter) {

		return getService().deleteNewsletter(newsletter);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.NewsletterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.NewsletterModelImpl</code>.
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

	public static com.liferay.amf.newsletter.model.Newsletter fetchNewsletter(
		long resourcePrimKey) {

		return getService().fetchNewsletter(resourcePrimKey);
	}

	/**
	 * Returns the newsletter matching the UUID and group.
	 *
	 * @param uuid the newsletter's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	public static com.liferay.amf.newsletter.model.Newsletter
		fetchNewsletterByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchNewsletterByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.amf.newsletter.model.Newsletter>
		getAllNewsletter() {

		return getService().getAllNewsletter();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.journal.model.JournalArticle getIssueSearch(
		long groupId, String articleId) {

		return getService().getIssueSearch(groupId, articleId);
	}

	public static String getJournalArticleContent(
		com.liferay.dynamic.data.mapping.model.DDMStructure ddmStructure,
		String content, String elementKey) {

		return getService().getJournalArticleContent(
			ddmStructure, content, elementKey);
	}

	/**
	 * Returns the newsletter with the primary key.
	 *
	 * @param resourcePrimKey the primary key of the newsletter
	 * @return the newsletter
	 * @throws PortalException if a newsletter with the primary key could not be found
	 */
	public static com.liferay.amf.newsletter.model.Newsletter getNewsletter(
			long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNewsletter(resourcePrimKey);
	}

	public static com.liferay.journal.model.JournalArticle
		getNewsletterByIssueNumber(long issueNumber) {

		return getService().getNewsletterByIssueNumber(issueNumber);
	}

	/**
	 * Returns the newsletter matching the UUID and group.
	 *
	 * @param uuid the newsletter's UUID
	 * @param groupId the primary key of the group
	 * @return the matching newsletter
	 * @throws PortalException if a matching newsletter could not be found
	 */
	public static com.liferay.amf.newsletter.model.Newsletter
			getNewsletterByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNewsletterByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.journal.model.JournalArticle>
		getNewsletters() {

		return getService().getNewsletters();
	}

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.amf.newsletter.model.impl.NewsletterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 */
	public static java.util.List<com.liferay.amf.newsletter.model.Newsletter>
		getNewsletters(int start, int end) {

		return getService().getNewsletters(start, end);
	}

	/**
	 * Returns all the newsletters matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletters
	 * @param companyId the primary key of the company
	 * @return the matching newsletters, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.amf.newsletter.model.Newsletter>
		getNewslettersByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getNewslettersByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of newsletters matching the UUID and company.
	 *
	 * @param uuid the UUID of the newsletters
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching newsletters, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.amf.newsletter.model.Newsletter>
		getNewslettersByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.amf.newsletter.model.Newsletter>
					orderByComparator) {

		return getService().getNewslettersByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
	 */
	public static int getNewslettersCount() {
		return getService().getNewslettersCount();
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
	 * Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NewsletterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was updated
	 */
	public static com.liferay.amf.newsletter.model.Newsletter updateNewsletter(
		com.liferay.amf.newsletter.model.Newsletter newsletter) {

		return getService().updateNewsletter(newsletter);
	}

	public static NewsletterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<NewsletterLocalService, NewsletterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsletterLocalService.class);

		ServiceTracker<NewsletterLocalService, NewsletterLocalService>
			serviceTracker =
				new ServiceTracker
					<NewsletterLocalService, NewsletterLocalService>(
						bundle.getBundleContext(), NewsletterLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}