package com.liferay.course.service.impl;

import com.liferay.course.model.Course;
import com.liferay.course.service.base.CourseLocalServiceBaseImpl;
import com.liferay.course.validator.CourseValidator;
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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "model.class.name=com.liferay.course.model.Course",
	service = AopService.class
)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	@Override
	public Course addCourse(Course course) {
		throw new UnsupportedOperationException("Not supported.");
	}

	public Course addCourse(
			long groupId, Map<Locale, String> courseNameMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> lecturerMap,
			long duration, String status, ServiceContext serviceContext)
		throws PortalException {

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		long courseId = counterLocalService.increment(Course.class.getName());

		_courseValidator.validate(courseId, courseNameMap, descriptionMap, lecturerMap, duration, getCourses() );

		Course course = createCourse(courseId);

		course.setCompanyId(group.getCompanyId());
		course.setCreateDate(serviceContext.getCreateDate(new Date()));
		course.setGroupId(groupId);
		course.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		course.setCourseNameMap(courseNameMap);
		course.setDescriptionMap(descriptionMap);
		course.setLecturerMap(lecturerMap);
		course.setUserId(userId);
		course.setUserName(user.getScreenName());
		course.setStatus(status);
		course.setDuration(duration);
		course.setCourseId(courseId);

		return super.addCourse(course);
	}

	public List<Course> getCourses() {
		return coursePersistence.findAll();
	}

	public List<Course> getCoursesByGroupId(long groupId) {
		return coursePersistence.findByGroupId(groupId);
	}

	public List<Course> getCoursesByGroupId(long groupId, int start, int end) {
		return coursePersistence.findByGroupId(groupId, start, end);
	}

	public List<Course> getCoursesByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return coursePersistence.findByGroupId(
			groupId, start, end, orderByComparator);
	}

	public List<Course> getCoursesByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return courseLocalService.dynamicQuery(
			getKeywordSearchDynamicQuery(groupId, keywords), start, end,
			orderByComparator);
	}

	public List<Course> getCoursesByStatus(String status) {
		List<Course> courses = getCourses();
		List<Course> courseByStatus = new ArrayList<>();

		for (Course course : courses) {
			if (course.getStatus().equals(status)) {
				courseByStatus.add(course);
			}
		}

		return courseByStatus;
	}

	public long getCoursesCountByKeywords(long groupId, String keywords) {
		return courseLocalService.dynamicQueryCount(
			getKeywordSearchDynamicQuery(groupId, keywords));
	}

	@Override
	public Course updateCourse(Course course) {
		throw new UnsupportedOperationException("Not supported.");
	}

	public Course updateCourse(
			long courseId, Map<Locale, String> courseNameMap,
			Map<Locale, String> descriptionMap, Map<Locale, String> lecturerMap,
			long duration, String status, ServiceContext serviceContext)
		throws PortalException {

		_courseValidator.validate(courseId, courseNameMap, descriptionMap, lecturerMap, duration, getCourses());

		Course course = getCourse(courseId);

		course.setModifiedDate(new Date());
		course.setCourseNameMap(courseNameMap);
		course.setDescriptionMap(descriptionMap);
		course.setLecturerMap(lecturerMap);
		course.setDuration(duration);
		course.setStatus(status);

		course = super.updateCourse(course);

		return course;
	}

	public Course updateCourseStatus(long courseId, String status)
		throws PortalException {

		Course course = getCourse(courseId);

		course.setStatus(status);

		course = super.updateCourse(course);

		return course;
	}

	private DynamicQuery getKeywordSearchDynamicQuery(
		long groupId, String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(
			RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery =
				RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(
				RestrictionsFactoryUtil.like(
					"courseName", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}

	@Reference
	CourseValidator _courseValidator;

}