package com.liferay.course.model.listener;

import com.liferay.course.model.CourseRegistration;
import com.liferay.course.service.CourseLocalService;
import com.liferay.course.service.CourseRegistrationLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;


import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelListener.class)
public class CourseModelListener extends BaseModelListener<CourseRegistration> {

	@Override
	public void onAfterUpdate(CourseRegistration courseRegistration)
		throws ModelListenerException {

		if (_courseRegistrationLocalService.getCourseRegistrationByStatus(
				"Approved", courseRegistration.getCourseId()).size() >= 2) {

			try {
				_courseLocalService.updateCourseStatus(
					courseRegistration.getCourseId(), "Full-registered");
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			try {
				_courseRegistrationLocalService.updateCourseRegistrationStatusWhenCourseIsFullRegister(courseRegistration.getCourseRegistrationId());
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}

	@Reference
	CourseLocalService _courseLocalService;

	@Reference
	CourseRegistrationLocalService _courseRegistrationLocalService;

}