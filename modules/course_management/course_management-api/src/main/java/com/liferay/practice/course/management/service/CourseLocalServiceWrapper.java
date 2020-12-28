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

package com.liferay.practice.course.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalService
 * @generated
 */
public class CourseLocalServiceWrapper
	implements CourseLocalService, ServiceWrapper<CourseLocalService> {

	public CourseLocalServiceWrapper(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	/**
	 * Adds the course to the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was added
	 */
	@Override
	public com.liferay.practice.course.management.model.Course addCourse(
		com.liferay.practice.course.management.model.Course course) {

		return _courseLocalService.addCourse(course);
	}

	@Override
	public com.liferay.practice.course.management.model.Course addCourse(
			long groupId, java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> lecturerMap,
			Long duration,
			boolean courseStatus,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.addCourse(
			groupId, courseNameMap, descriptionMap, lecturerMap, duration,
			courseStatus, serviceContext);
	}

	/**
	 * Creates a new course with the primary key. Does not add the course to the database.
	 *
	 * @param courseId the primary key for the new course
	 * @return the new course
	 */
	@Override
	public com.liferay.practice.course.management.model.Course createCourse(
		long courseId) {

		return _courseLocalService.createCourse(courseId);
	}

	/**
	 * Deletes the course from the database. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was removed
	 */
	@Override
	public com.liferay.practice.course.management.model.Course deleteCourse(
		com.liferay.practice.course.management.model.Course course) {

		return _courseLocalService.deleteCourse(course);
	}

	/**
	 * Deletes the course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseId the primary key of the course
	 * @return the course that was removed
	 * @throws PortalException if a course with the primary key could not be found
	 */
	@Override
	public com.liferay.practice.course.management.model.Course deleteCourse(
			long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.deleteCourse(courseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseLocalService.dynamicQuery();
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

		return _courseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.practice.course.management.model.impl.CourseModelImpl</code>.
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

		return _courseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.practice.course.management.model.impl.CourseModelImpl</code>.
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

		return _courseLocalService.dynamicQuery(
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

		return _courseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _courseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.practice.course.management.model.Course fetchCourse(
		long courseId) {

		return _courseLocalService.fetchCourse(courseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _courseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the course with the primary key.
	 *
	 * @param courseId the primary key of the course
	 * @return the course
	 * @throws PortalException if a course with the primary key could not be found
	 */
	@Override
	public com.liferay.practice.course.management.model.Course getCourse(
			long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.getCourse(courseId);
	}

	/**
	 * Returns a range of all the courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.practice.course.management.model.impl.CourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of courses
	 * @param end the upper bound of the range of courses (not inclusive)
	 * @return the range of courses
	 */
	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCourses(int start, int end) {

		return _courseLocalService.getCourses(start, end);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByGroupId(long groupId) {

		return _courseLocalService.getCoursesByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByGroupId(long groupId, int start, int end) {

		return _courseLocalService.getCoursesByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.practice.course.management.model.Course>
					orderByComparator) {

		return _courseLocalService.getCoursesByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.practice.course.management.model.Course>
					orderByComparator) {

		return _courseLocalService.getCoursesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns the number of courses.
	 *
	 * @return the number of courses
	 */
	@Override
	public int getCoursesCount() {
		return _courseLocalService.getCoursesCount();
	}

	@Override
	public long getCoursesCountByKeywords(long groupId, String keywords) {
		return _courseLocalService.getCoursesCountByKeywords(groupId, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _courseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the course in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param course the course
	 * @return the course that was updated
	 */
	@Override
	public com.liferay.practice.course.management.model.Course updateCourse(
		com.liferay.practice.course.management.model.Course course) {

		return _courseLocalService.updateCourse(course);
	}

	@Override
	public com.liferay.practice.course.management.model.Course updateCourse(
			long courseId,
			java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap,
			java.util.Map<java.util.Locale, String> lecturerMap,
			Long duration,
			boolean courseStatus,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseLocalService.updateCourse(
			courseId, courseNameMap, descriptionMap, lecturerMap, duration,
			courseStatus, serviceContext);
	}

	@Override
	public CourseLocalService getWrappedService() {
		return _courseLocalService;
	}

	@Override
	public void setWrappedService(CourseLocalService courseLocalService) {
		_courseLocalService = courseLocalService;
	}

	private CourseLocalService _courseLocalService;

}