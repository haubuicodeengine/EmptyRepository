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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Course. This utility wraps
 * <code>com.liferay.practice.course.management.service.impl.CourseServiceImpl</code>
 * and is an access point for service operations in application layer code
 * running on a remote server. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @generated
 */
public class CourseServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.liferay.practice.course.management.service.impl.CourseServiceImpl</
	 * code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.practice.course.management.model.Course addCourse(long groupId,
			java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, java.util.Map<java.util.Locale, String> lecturerMap,
			java.util.Map<java.util.Locale, String> durationMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addCourse(groupId, courseNameMap, descriptionMap, lecturerMap, durationMap, serviceContext);
	}

	public static com.liferay.practice.course.management.model.Course deleteCourse(long courseId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCourse(courseId);
	}

	public static com.liferay.practice.course.management.model.Course getCourse(long courseId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCourse(courseId);
	}

	public static java.util.List<com.liferay.practice.course.management.model.Course> getCoursesByGroupId(
			long groupId) {

		return getService().getCoursesByGroupId(groupId);
	}

	public static java.util.List<com.liferay.practice.course.management.model.Course> getCoursesByKeywords(long groupId,
			String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<com.liferay.practice.course.management.model.Course> orderByComparator) {

		return getService().getCoursesByKeywords(groupId, keywords, start, end, orderByComparator);
	}

	public static long getCoursesCountByKeywords(long groupId, String keywords) {

		return getService().getCoursesCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.practice.course.management.model.Course updateCourse(long courseId,
			java.util.Map<java.util.Locale, String> courseNameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, java.util.Map<java.util.Locale, String> lecturerMap,
			java.util.Map<java.util.Locale, String> durationMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCourse(courseId, courseNameMap, descriptionMap, lecturerMap, durationMap,
				serviceContext);
	}

	public static CourseService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CourseService, CourseService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CourseService.class);

		ServiceTracker<CourseService, CourseService> serviceTracker = new ServiceTracker<CourseService, CourseService>(
				bundle.getBundleContext(), CourseService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}