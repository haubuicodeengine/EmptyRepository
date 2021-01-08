package com.liferay.practice.course.management.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.service.CourseService;
import com.liferay.practice.course.management.service.RegistrationService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author ces-user
 */
@Component(immediate = true, property = {
		// TODO enter required service properties
}, service = ModelListener.class)
public class CourseModelListener extends BaseModelListener<Registration> {

	@Override
	public void onAfterCreate(Registration model) throws ModelListenerException {

		List<Registration> registrations = _registrationService.getListRegistration();
		int count = 0;

		for (Registration registration : registrations) {

			if (registration.getCourseId() == model.getCourseId()) {

				count++;
			}
		}

		if (count <= 20) {

			try {
				_courseService.updateCourseStatus(model.getCourseId(), 2);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		super.onAfterCreate(model);

	}

	@Reference
	RegistrationService _registrationService;

	@Reference
	CourseService _courseService;
}