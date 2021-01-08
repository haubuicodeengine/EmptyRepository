package com.liferay.course.service.impl;

import com.liferay.course.model.Course;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseLocalService;
import com.liferay.course.service.base.CourseRegistrationLocalServiceBaseImpl;
import com.liferay.course.validator.CourseRegistrationValidator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	property = "model.class.name=com.liferay.course.model.CourseRegistration",
	service = AopService.class
)
public class CourseRegistrationLocalServiceImpl
	extends CourseRegistrationLocalServiceBaseImpl {

	@Override
	public CourseRegistration addCourseRegistration(
		CourseRegistration CourseRegistration) {

		throw new UnsupportedOperationException("Not supported.");
	}

	public CourseRegistration addCourseRegistration(
			long groupId, long courseId, String status,
			ServiceContext serviceContext)
		throws PortalException {

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		_CourseRegistrationValidator.validate(
			courseId, userId, getCourseRegistrations());

		long CourseRegistrationId = counterLocalService.increment(
			CourseRegistration.class.getName());

		CourseRegistration CourseRegistration = createCourseRegistration(
			CourseRegistrationId);

		CourseRegistration.setCompanyId(group.getCompanyId());
		CourseRegistration.setCreateDate(
			serviceContext.getCreateDate(new Date()));
		CourseRegistration.setGroupId(groupId);
		CourseRegistration.setModifiedDate(
			serviceContext.getModifiedDate(new Date()));
		CourseRegistration.setUserId(userId);
		CourseRegistration.setUserName(user.getScreenName());
		CourseRegistration.setCourseId(courseId);
		CourseRegistration.setStatus(status);

		return super.addCourseRegistration(CourseRegistration);
	}

	public List<Long> getCourseIdRegistrationByUserId(long userId) {
		List<CourseRegistration> CourseRegistrations =
			getCourseRegistrationByUserId(userId);
		List<Long> courseIds = new ArrayList<>();

		for (CourseRegistration CourseRegistration : CourseRegistrations) {
			if (CourseRegistration.getUserId() == userId) {
				courseIds.add(CourseRegistration.getCourseId());
			}
		}

		return courseIds;
	}

	public List<CourseRegistration> getCourseRegistrationByStatus(
		String status, long courseId) {

		List<CourseRegistration> coursesCourseRegistrations =
			getCourseRegistrationsByCourseId(courseId);
		List<CourseRegistration> coursesByStatus = new ArrayList<>();

		for (CourseRegistration CourseRegistration :
				coursesCourseRegistrations) {

			if (CourseRegistration.getStatus().equals(status)) {
				coursesByStatus.add(CourseRegistration);
			}
		}

		return coursesByStatus;
	}

	public List<CourseRegistration> getCourseRegistrationByUserId(long userId) {
		List<CourseRegistration> CourseRegistrations = getCourseRegistrations();
		List<CourseRegistration> coursesRegisted = new ArrayList<>();

		for (CourseRegistration CourseRegistration : CourseRegistrations) {
			if (CourseRegistration.getUserId() == userId) {
				coursesRegisted.add(CourseRegistration);
			}
		}

		return coursesRegisted;
	}

	public List<CourseRegistration> getCourseRegistrations() {
		return courseRegistrationPersistence.findAll();
	}

	@Override
	public CourseRegistration updateCourseRegistration(
		CourseRegistration courseRegistration) {

		throw new UnsupportedOperationException("Not supported.");
	}

	public CourseRegistration updateCourseRegistration(
			long courseRegistrationId, String status)
		throws PortalException {

		CourseRegistration courseRegistration = getCourseRegistration(courseRegistrationId);

		courseRegistration.setStatus(status);
		
		courseRegistration = super.updateCourseRegistration(courseRegistration);

		return courseRegistration;
	}
	
	public void updateCourseRegistrationStatusWhenCourseIsFullRegister(long courseRegistrationId) throws PortalException {
		
		CourseRegistration courseRegistration = getCourseRegistration(
				courseRegistrationId);
			
		Course course = _courseLocalService.getCourse(courseRegistration.getCourseId());

		if(course.getStatus().equals("Full-registered")) {

			List<CourseRegistration> courseRegistrations =
					getCourseRegistrationByStatus(
						"Waiting-approval", courseRegistration.getCourseId());

			for (CourseRegistration item : courseRegistrations) {
				
				updateCourseRegistration(item.getCourseRegistrationId(), "Rejected");
			}	
		}
	}

	private List<CourseRegistration> getCourseRegistrationsByCourseId(
		long courseId) {

		List<CourseRegistration> coursesCourseRegistrations =
			getCourseRegistrations();
		List<CourseRegistration> coursesByCourseId = new ArrayList<>();

		for (CourseRegistration CourseRegistration :
				coursesCourseRegistrations) {

			if (CourseRegistration.getCourseId() == courseId) {
				coursesByCourseId.add(CourseRegistration);
			}
		}

		return coursesByCourseId;
	}

	@Reference
	CourseRegistrationValidator _CourseRegistrationValidator;

	@Reference
	CourseLocalService _courseLocalService;

}