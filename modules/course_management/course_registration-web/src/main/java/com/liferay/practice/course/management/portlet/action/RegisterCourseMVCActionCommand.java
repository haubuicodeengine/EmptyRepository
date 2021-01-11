package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.exception.CourseAlreadyRegisteredException;
import com.liferay.practice.course.management.exception.CourseFullRegisteredException;
import com.liferay.practice.course.management.model.Registration;
import com.liferay.practice.course.management.registration.portlet.constants.CourseRegistrationMVCPortletKeys;
import com.liferay.practice.course.management.registration.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.CourseService;
import com.liferay.practice.course.management.service.RegistrationService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CourseRegistrationMVCPortletKeys.COURSEREGISTRATIONMVC,
		"mvc.command.name=" + MVCCommandNames.REGISTER_COURSE }, service = MVCActionCommand.class)
public class RegisterCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long courseId = ParamUtil.getLong(actionRequest, "courseId");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Registration.class.getName(), actionRequest);

		try {

			_registrationService.registerCourse(themeDisplay.getCompanyGroupId(), courseId, 0, serviceContext);
			SessionMessages.add(actionRequest, "RegistrationAdded");
			sendRedirect(actionRequest, actionResponse);
		} catch (CourseAlreadyRegisteredException care) {

			SessionErrors.add(actionRequest, care.getMessage());
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COURSES);
		}catch (CourseFullRegisteredException cfre) {

			SessionErrors.add(actionRequest, cfre.getMessage());
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COURSES);
		} catch (PortalException pe) {

			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.VIEW_COURSES);
		}
	}

	@Reference
	protected RegistrationService _registrationService;

	@Reference
	protected CourseService _courseService;
}
