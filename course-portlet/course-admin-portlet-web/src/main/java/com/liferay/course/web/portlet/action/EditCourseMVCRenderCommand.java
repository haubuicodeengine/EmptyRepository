package com.liferay.course.web.portlet.action;

import com.liferay.course.exception.NoSuchCourseException;
import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.course.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CoursePortletKeys.COURSE,
		"mvc.command.name=" + MVCCommandNames.EDIT_COURSE
	},
	service = MVCRenderCommand.class
)
public class EditCourseMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		Course course = null;

		long courseId = ParamUtil.getLong(renderRequest, "courseId", 0);

		if (courseId > 0) {
			try {

				course = _courseService.getCourse(courseId);
			}
			catch (NoSuchCourseException nsae) {
				nsae.printStackTrace();
			}
			catch (PortalException pe) {
				pe.printStackTrace();
			}
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		// Set back icon visible.

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		portletDisplay.setShowBackIcon(true);

		String redirect = renderRequest.getParameter("redirect");

		portletDisplay.setURLBack(redirect);

		// Set course to the request attributes.

		renderRequest.setAttribute("course", course);
		renderRequest.setAttribute("courseClass", Course.class);

		return "/course/form_course.jsp";
	}

	@Reference
	private CourseService _courseService;

}