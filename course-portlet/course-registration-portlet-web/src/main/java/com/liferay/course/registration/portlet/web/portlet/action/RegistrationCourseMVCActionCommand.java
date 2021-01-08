package com.liferay.course.registration.portlet.web.portlet.action;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.model.Course;
import com.liferay.course.registration.portlet.web.constants.CourseRegistrationPortletKeys;
import com.liferay.course.registration.portlet.web.constants.MVCCommandNames;
import com.liferay.course.service.CourseRegistrationService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
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
		"javax.portlet.name=" + CourseRegistrationPortletKeys.COURSE_REGISTRATION,
		"mvc.command.name=" + MVCCommandNames.REGISTRATION_COURSE_ADD
	},
	service = MVCActionCommand.class
)
public class RegistrationCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Course.class.getName(), actionRequest);

		if (themeDisplay.isSignedIn()) {
			long courseId = ParamUtil.getLong(actionRequest, "courseId", 0);

			try {
				_courseRegistrationService.addCourseRegistration(
					themeDisplay.getScopeGroupId(), courseId,
					"Waiting-approval", serviceContext);

				SessionMessages.add(actionRequest, "courseRegistrationSuccess");

				sendRedirect(actionRequest, actionResponse);
			}
			catch (Exception exception) {
				if (exception instanceof CourseValidationException) {
					SessionErrors.add(actionRequest, exception.getClass());
					actionResponse.setRenderParameter(
							"mvcRenderCommandName", MVCCommandNames.VIEW_COURSES);
				}		
			}
		}
		else {
			SessionErrors.add(
				actionRequest, "NoRequireToAccess", "no-require-to-access");
		}
	}

	@Reference
	protected CourseRegistrationService _courseRegistrationService;

}