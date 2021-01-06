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

package com.liferay.practice.course.management.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.service.base.CourseServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the course remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.practice.course.management.service.CourseService</code>
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=coursemanagement",
		"json.web.service.context.path=Course" }, service = AopService.class)
public class CourseServiceImpl extends CourseServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.liferay.practice.course.management.service.CourseServiceUtil</code>
	 * to access the course remote service.
	 */

	public Course addCourse(long groupId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration, int courseStatus, ServiceContext serviceContext)
			throws PortalException {

		return courseLocalService.addCourse(groupId, courseNameMap, descriptionMap, lecturerMap, duration, courseStatus,
				serviceContext);
	}

	public Course deleteCourse(long courseId) throws PortalException {

		Course course = courseLocalService.getCourse(courseId);

		return courseLocalService.deleteCourse(course);
	}

	public Course getCourse(long courseId) throws PortalException {

		Course course = courseLocalService.getCourse(courseId);

		return course;
	}

	public List<Course> getCoursesByGroupId(long groupId) {

		return coursePersistence.findByGroupId(groupId);
	}

	public List<Course> getCoursesByKeywords(long groupId, String keywords, int start, int end,
			OrderByComparator<Course> orderByComparator) {

		return courseLocalService.getCoursesByKeywords(groupId, keywords, start, end, orderByComparator);
	}

	public long getCoursesCountByKeywords(long groupId, String keywords) {

		return courseLocalService.getCoursesCountByKeywords(groupId, keywords);
	}

	public Course updateCourse(long courseId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration, int courseStatus, ServiceContext serviceContext)
			throws PortalException {

		return courseLocalService.updateCourse(courseId, courseNameMap, descriptionMap, lecturerMap, duration,
				courseStatus, serviceContext);
	}

	@Override
	public List<Long> getListCourseByUserId(long userId) {

		return courseLocalService.getListCourseByUserId(userId);
	}

	@Override
	public Course updateCourseStatus(long courseId, int status) throws PortalException {

		return courseLocalService.updateCourseStatus(courseId, status);
	}
}