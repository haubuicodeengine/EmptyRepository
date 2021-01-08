package com.liferay.course.registration.approval.web.portlet.action;

import com.liferay.course.exception.CourseRegistrationValidationException;
import com.liferay.course.registration.approval.constants.*;
import com.liferay.course.service.CourseRegistrationService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RegistrationApprovalPortletKeys.REGISTRATION_APPROVAL,
		"mvc.command.name=" + MVCCommandNames.APPROVAL_COURSE
	},
	service = MVCActionCommand.class
)
public class ApproveCourseRegisterMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			
			long courseRegistrationId = ParamUtil.getLong(
				actionRequest, "courseRegistrationId", 0);

			try {
				_courseRegistrationService.updateCourseRegistration(
					courseRegistrationId, "Approved");
				SessionMessages.add(actionRequest, "approveCourseRegistrationSuccess");

				sendRedirect(actionRequest, actionResponse);
			}
			catch (Exception exception) {
				if (exception instanceof CourseRegistrationValidationException) {
					SessionErrors.add(actionRequest, exception.getClass());
					actionResponse.setRenderParameter(
							"mvcRenderCommandName", MVCCommandNames.VIEW_COURSES_IN_APPROVAL_PORTLET);
				}		
			}
		}
		else {
			SessionErrors.add(
				actionRequest, "serviceErrorDetails",
				"You do not have the roles required to access this portlet.");
		}
	}

	@Reference
	protected CourseRegistrationService _courseRegistrationService;

}