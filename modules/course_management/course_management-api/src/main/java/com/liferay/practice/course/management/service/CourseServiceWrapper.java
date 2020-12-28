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
 * Provides a wrapper for {@link CourseService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @generated
 */
public class CourseServiceWrapper
	implements CourseService, ServiceWrapper<CourseService> {

	public CourseServiceWrapper(CourseService courseService) {
		_courseService = courseService;
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

		return _courseService.addCourse(
			groupId, courseNameMap, descriptionMap, lecturerMap, duration,
			courseStatus, serviceContext);
	}

	@Override
	public com.liferay.practice.course.management.model.Course deleteCourse(
			long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseService.deleteCourse(courseId);
	}

	@Override
	public com.liferay.practice.course.management.model.Course getCourse(
			long courseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseService.getCourse(courseId);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByGroupId(long groupId) {

		return _courseService.getCoursesByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.practice.course.management.model.Course>
		getCoursesByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.practice.course.management.model.Course>
					orderByComparator) {

		return _courseService.getCoursesByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public long getCoursesCountByKeywords(long groupId, String keywords) {
		return _courseService.getCoursesCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseService.getOSGiServiceIdentifier();
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

		return _courseService.updateCourse(
			courseId, courseNameMap, descriptionMap, lecturerMap, duration,
			courseStatus, serviceContext);
	}

	@Override
	public CourseService getWrappedService() {
		return _courseService;
	}

	@Override
	public void setWrappedService(CourseService courseService) {
		_courseService = courseService;
	}

	private CourseService _courseService;

}