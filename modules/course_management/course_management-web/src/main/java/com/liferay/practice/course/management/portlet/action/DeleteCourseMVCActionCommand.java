package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.practice.course.management.portlet.constants.CourseManagementMVCPortletKeys;
import com.liferay.practice.course.management.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.CourseService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CourseManagementMVCPortletKeys.COURSEMANAGEMENTMVC,
		"mvc.command.name=" + MVCCommandNames.DELETE_COURSE }, service = MVCActionCommand.class)
public class DeleteCourseMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long courseId = ParamUtil.getLong(actionRequest, "courseId");

		try {

			_courseService.deleteCourse(courseId);
			SessionMessages.add(actionRequest, "courseDeleted");

		} catch (PortalException pe) {

			SessionErrors.add(actionRequest, "serviceErrorDetails", pe);
			pe.printStackTrace();
		}
	}

	@Reference
	protected CourseService _courseService;
}
