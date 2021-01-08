package com.liferay.course.service.impl;

import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.base.CourseRegistrationServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"json.web.service.context.name=course",
		"json.web.service.context.path=CourseRegistration"
	},
	service = AopService.class
)
public class CourseRegistrationServiceImpl
	extends CourseRegistrationServiceBaseImpl {

	public CourseRegistration addCourseRegistration(
			long groupId, long courseId, String status,
			ServiceContext serviceContext)
		throws PortalException {

		return courseRegistrationLocalService.addCourseRegistration(
			groupId, courseId, status, serviceContext);
	}

	public CourseRegistration deleteCourseRegistration(
			long courseRegistrationId)
		throws PortalException {

		CourseRegistration courseRegistration =
			courseRegistrationLocalService.getCourseRegistration(
				courseRegistrationId);

		return courseRegistrationLocalService.deleteCourseRegistration(
			courseRegistration);
	}

	public List<Long> getCourseIdRegistrationByUserId(long userId) {
		return courseRegistrationLocalService.getCourseIdRegistrationByUserId(
			userId);
	}

	public List<CourseRegistration> getCourseRegistrationByStatus(
		String status, long courseId) {

		return courseRegistrationLocalService.getCourseRegistrationByStatus(
			status, courseId);
	}

	public List<CourseRegistration> getCourseRegistrationByUserId(long userId) {
		return courseRegistrationLocalService.getCourseRegistrationByUserId(
			userId);
	}

	@Override
	public List<CourseRegistration> getCourseRegistrations() {
		return courseRegistrationLocalService.getCourseRegistrations();
	}

	public CourseRegistration updateCourseRegistration(
			long courseRegistrationId, String status)
		throws PortalException {

		return courseRegistrationLocalService.updateCourseRegistration(
			courseRegistrationId, status);
	}
	
	public void updateCourseRegistrationStatusWhenCourseIsFullRegister(long courseRegistrationId)
			throws PortalException {
		courseRegistrationLocalService.updateCourseRegistrationStatusWhenCourseIsFullRegister(courseRegistrationId);
	}

}