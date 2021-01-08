package com.liferay.course.registration.portlet.web.portlet.action;

import com.liferay.course.registration.portlet.web.constants.CourseRegistrationPortletKeys;
import com.liferay.course.registration.portlet.web.constants.MVCCommandNames;
import com.liferay.course.service.CourseRegistrationService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CourseRegistrationPortletKeys.COURSE_REGISTRATION,
		"mvc.command.name=" + MVCCommandNames.REGISTRATION_COURSE_DELETE
	},
	service = MVCActionCommand.class
)
public class DeleteCourseRegistrationMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long courseRegistrationId = ParamUtil.getLong(
			actionRequest, "courseRegistrationId", 0);

		try {
			_courseRegistrationService.deleteCourseRegistration(
				courseRegistrationId);

			SessionMessages.add(actionRequest, "courseRegistrationDeleted");
		}
		catch (PortalException pe) {
			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
		}
	}

	@Reference
	protected CourseRegistrationService _courseRegistrationService;

}