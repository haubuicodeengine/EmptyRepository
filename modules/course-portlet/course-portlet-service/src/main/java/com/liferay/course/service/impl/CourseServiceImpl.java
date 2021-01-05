package com.liferay.course.service.impl;

import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

@Component(property = { "json.web.service.context.name=course",
		"json.web.service.context.path=Course" }, service = AopService.class)
public class CourseServiceImpl extends CourseServiceBaseImpl {

	public Course addCourse(long groupId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration, boolean status, ServiceContext serviceContext)
			throws PortalException {

		return courseLocalService.addCourse(groupId, courseNameMap, descriptionMap, lecturerMap, duration, status,
				serviceContext);
	}

	public Course deleteCourse(long courseId) throws PortalException {

		Course course = courseLocalService.getCourse(courseId);

		return courseLocalService.deleteCourse(course);
	}

	public Course getCourse(long CourseId) throws PortalException {

		Course course = courseLocalService.getCourse(CourseId);

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

	public Course updateCourse(long groupId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration, boolean status, ServiceContext serviceContext)
			throws PortalException {

		return courseLocalService.updateCourse(groupId, courseNameMap, descriptionMap, lecturerMap, duration, status,
				serviceContext);
	}
}