package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.exception.DurationValueException;
import com.liferay.practice.course.management.exception.StringLengthException;
import com.liferay.practice.course.management.exception.StringNullException;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.portlet.constants.CourseManagementMVCPortletKeys;
import com.liferay.practice.course.management.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.CourseService;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CourseManagementMVCPortletKeys.COURSEMANAGEMENTMVC,
		"mvc.command.name=" + MVCCommandNames.ADD_COURSE }, service = MVCActionCommand.class)
public class AddCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), actionRequest);

		Map<Locale, String> courseNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "courseName");
		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");
		Map<Locale, String> lecturerMap = LocalizationUtil.getLocalizationMap(actionRequest, "lecturer");

		String durationStr = ParamUtil.getString(actionRequest, "duration");
		Long duration = Long.parseLong(durationStr);
		String courseStatusStr = ParamUtil.getString(actionRequest, "courseStatus");
		int courseStatus = Integer.parseInt(courseStatusStr);

		try {

			_courseService.addCourse(themeDisplay.getScopeGroupId(), courseNameMap, descriptionMap, lecturerMap,
					duration, courseStatus, serviceContext);
			SessionMessages.add(actionRequest, "courseAdded");
			sendRedirect(actionRequest, actionResponse);
		} catch (DurationValueException dve) {

			SessionErrors.add(actionRequest, dve.getMessage());
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
		} catch (StringLengthException sle) {

			SessionErrors.add(actionRequest, sle.getMessage());
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
		} catch (StringNullException sne) {

			SessionErrors.add(actionRequest, sne.getMessage());
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
		} catch (PortalException pe) {
			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
		}
	}

	@Reference
	protected CourseService _courseService;
}
