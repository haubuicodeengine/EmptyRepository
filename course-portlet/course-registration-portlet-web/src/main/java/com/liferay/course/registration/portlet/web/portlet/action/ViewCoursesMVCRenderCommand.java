package com.liferay.course.registration.portlet.web.portlet.action;

import com.liferay.course.model.Course;
import com.liferay.course.model.CourseRegistration;
import com.liferay.course.registration.portlet.web.constants.CourseRegistrationPortletKeys;
import com.liferay.course.registration.portlet.web.constants.MVCCommandNames;
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
		"javax.portlet.name=" + CourseRegistrationPortletKeys.COURSE_REGISTRATION,
		"mvc.command.name=/", "mvc.command.name=" + MVCCommandNames.VIEW_COURSES
	},
	service = MVCRenderCommand.class
)
public class ViewCoursesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		addcourseListAttributes(renderRequest);

		return "/view.jsp";
	}

	@Reference
	protected CourseRegistrationService _courseRegistrationService;

	@Reference
	protected CourseService _courseService;

	private void addcourseListAttributes(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		List<Course> courseAvailable = _courseService.getCoursesByStatus(
			"Available");

		List<Course> courses = _courseService.getCourses();

		List<CourseRegistration> coursesRegistered =
			_courseRegistrationService.getCourseRegistrationByUserId(
				themeDisplay.getUserId());

		List<Long> listCourseIdRegistered =
			_courseRegistrationService.getCourseIdRegistrationByUserId(
				themeDisplay.getUserId());

		renderRequest.setAttribute("courses", courses);

		renderRequest.setAttribute("coursesAvailable", courseAvailable);

		renderRequest.setAttribute("coursesRegistered", coursesRegistered);

		renderRequest.setAttribute(
			"listCourseIdRegistered", listCourseIdRegistered);
	}

	@Reference
	private Portal _portal;

}