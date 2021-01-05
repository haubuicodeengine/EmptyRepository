package com.liferay.course.web.portlet.action;

import com.liferay.course.exception.CourseValidationException;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.course.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CoursePortletKeys.COURSE,
		"mvc.command.name=" + MVCCommandNames.EDIT_COURSE }, service = MVCActionCommand.class)
public class EditCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Course.class.getName(), actionRequest);

		long courseId = ParamUtil.getLong(actionRequest, "courseId");

		Map<Locale, String> courseNameMap = LocalizationUtil.getLocalizationMap(actionRequest, "courseName");

		Map<Locale, String> descriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, "description");

		Map<Locale, String> lecturerMap = LocalizationUtil.getLocalizationMap(actionRequest, "lecturer");

		long duration = Long.parseLong(actionRequest.getParameter("duration"));

		String statusValue = actionRequest.getParameter("status");

		boolean status = false;

		if (Long.parseLong(statusValue) == 1) {
			status = true;
		} else {
			status = false;
		}

		try {
			_courseService.updateCourse(courseId, courseNameMap, descriptionMap, lecturerMap, duration, status,
					serviceContext);

			SessionMessages.add(actionRequest, "courseUpdated");

			sendRedirect(actionRequest, actionResponse);
		} catch (CourseValidationException ave) {

			ave.printStackTrace();

			ave.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));

			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);

		} catch (PortalException pe) {

			pe.printStackTrace();

			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);

			actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.EDIT_COURSE);
		}
	}

	@Reference
	protected CourseService _courseService;
}
