package com.liferay.course.registration.approval.web.portlet.action;

import com.liferay.course.model.*;
import com.liferay.course.registration.approval.constants.*;
import com.liferay.course.service.CourseRegistrationService;
import com.liferay.course.service.CourseService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + RegistrationApprovalPortletKeys.REGISTRATION_APPROVAL,
		"mvc.command.name=/",
		"mvc.command.name=" + MVCCommandNames.VIEW_COURSES_IN_APPROVAL_PORTLET
	},
	service = MVCRenderCommand.class
)
public class ViewCoursesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		addCourseRegistedListAttributes(renderRequest);

		return "/view.jsp";
	}

	@Reference
	protected CourseRegistrationService _courseRegistrationService;

	@Reference
	protected CourseService _courseService;

	private void addCourseRegistedListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<Course> courses = _courseService.getCourses();

		List<CourseRegistration> coursesRegistered =
			_courseRegistrationService.getCourseRegistrations();

		renderRequest.setAttribute("courses", courses);

		renderRequest.setAttribute("coursesRegistered", coursesRegistered);
	}

	@Reference
	private Portal _portal;

}