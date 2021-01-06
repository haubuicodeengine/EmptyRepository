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
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.service.base.CourseLocalServiceBaseImpl;
import com.liferay.practice.course.management.validator.CourseValidator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the course local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.practice.course.management.service.CourseLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CourseLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.practice.course.management.model.Course", service = AopService.class)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	public Course addCourse(long groupId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration, int courseStatus, ServiceContext serviceContext)
			throws PortalException {

		_courseValidator.validate(courseNameMap, descriptionMap, lecturerMap, duration);

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		long courseId = counterLocalService.increment(Course.class.getName());

		Course course = createCourse(courseId);

		course.setCompanyId(group.getCompanyId());
		course.setCreateDate(serviceContext.getCreateDate(new Date()));
		course.setLecturerMap(lecturerMap);
		course.setDescriptionMap(descriptionMap);
		course.setDuration(duration);
		course.setCourseStatus(courseStatus);
		course.setGroupId(groupId);
		course.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		course.setCourseNameMap(courseNameMap);
		course.setUserId(userId);
		course.setUserName(user.getScreenName());

		return super.addCourse(course);
	}

	@Override
	public Course updateCourseStatus(long courseId, int status) throws PortalException {

		Course course = getCourse(courseId);
		course.setModifiedDate(new Date());
		course.setCourseStatus(status);
		course = super.updateCourse(course);

		return course;
	}

	public Course updateCourse(long courseId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, Long duration, int courseStatus, ServiceContext serviceContext)
			throws PortalException {

		_courseValidator.validate(courseNameMap, descriptionMap, lecturerMap, duration);

		Course course = getCourse(courseId);
		course.setModifiedDate(new Date());
		course.setLecturerMap(lecturerMap);
		course.setDescriptionMap(descriptionMap);
		course.setDuration(duration);
		course.setCourseStatus(courseStatus);
		course.setCourseNameMap(courseNameMap);

		course = super.updateCourse(course);

		return course;
	}

	public List<Course> getCoursesByGroupId(long groupId) {

		return coursePersistence.findByGroupId(groupId);
	}

	public List<Course> getCoursesByGroupId(long groupId, int start, int end) {

		return coursePersistence.findByGroupId(groupId, start, end);
	}

	public List<Course> getCoursesByGroupId(long groupId, int start, int end,
			OrderByComparator<Course> orderByComparator) {

		return coursePersistence.findByGroupId(groupId, start, end, orderByComparator);
	}

	public List<Course> getCoursesByKeywords(long groupId, String keywords, int start, int end,
			OrderByComparator<Course> orderByComparator) {

		return courseLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keywords), start, end,
				orderByComparator);
	}

	public long getCoursesCountByKeywords(long groupId, String keywords) {
		return courseLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(groupId, keywords));
	}

	@Override
	public List<Long> getListCourseByUserId(long userId) {

		List<Long> courses = new ArrayList<>();
		List<Course> allCourse = coursePersistence.findAll();

		for (Course course : allCourse) {

			if (course.getUserId() == userId) {
				courses.add(course.getCourseId());
			}
		}

		return courses;
	}

	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("courseName", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

	@Override
	public Course addCourse(Course course) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public Course updateCourse(Course course) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Reference
	CourseValidator _courseValidator;

}