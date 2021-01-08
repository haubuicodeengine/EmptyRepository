package com.liferay.course.web.portlet.action;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.course.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CoursePortletKeys.COURSE,
		"mvc.command.name=" + MVCCommandNames.ADD_COURSE
	},
	service = MVCActionCommand.class
)
public class AddCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Course.class.getName(), actionRequest);

		Map<Locale, String> courseNameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "courseName");

		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		Map<Locale, String> lecturerMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "lecturer");

		long duration = Long.parseLong(actionRequest.getParameter("duration"));

		String status = actionRequest.getParameter("status");
		
		try {

			// Call the service to add a a new course.

			_courseService.addCourse(
				themeDisplay.getScopeGroupId(), courseNameMap, descriptionMap,
				lecturerMap, duration, status, serviceContext);

			SessionMessages.add(actionRequest, "courseAdded");

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception exception) {
			if (exception instanceof CourseValidationException) {
				SessionErrors.add(actionRequest, exception.getClass());
				actionResponse.setRenderParameter(
						"mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
			}		
		}
	}

	@Reference
	protected CourseService _courseService;

}