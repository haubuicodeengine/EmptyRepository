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

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(property = "model.class.name=com.liferay.course.model.Course", service = AopService.class)
public class CourseLocalServiceImpl extends CourseLocalServiceBaseImpl {

	public Course addCourse(long groupId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration, boolean status, ServiceContext serviceContext) throws PortalException {

		_courseValidator.validate(courseNameMap, descriptionMap, lecturerMap, duration);

		// Get group and user.

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the Course.

		long CourseId = counterLocalService.increment(Course.class.getName());

		// Create assigment. This doesn't yet persist the entity.

		Course course = createCourse(CourseId);

		// Populate fields.

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
		// Persist Course to database.

		return super.addCourse(course);
	}

	public Course updateCourse(long courseId, Map<Locale, String> courseNameMap, Map<Locale, String> descriptionMap,
			Map<Locale, String> lecturerMap, long duration, boolean status, ServiceContext serviceContext) throws PortalException {

		_courseValidator.validate(courseNameMap, descriptionMap, lecturerMap, duration);

		// Get the Course by id.

		Course course = getCourse(courseId);

		// Set updated fields and modification date.

		course.setModifiedDate(new Date());
		course.setCourseNameMap(courseNameMap);
		course.setDescriptionMap(descriptionMap);
		course.setLecturerMap(lecturerMap);
		course.setDuration(duration);
		course.setStatus(status);

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

	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("courseName", "%" + keywords + "%"));
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