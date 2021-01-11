package com.liferay.practice.course.management.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.practice.course.management.exception.NoSuchCourseException;
import com.liferay.practice.course.management.model.Course;
import com.liferay.practice.course.management.portlet.constants.CourseManagementMVCPortletKeys;
import com.liferay.practice.course.management.portlet.constants.MVCCommandNames;
import com.liferay.practice.course.management.service.CourseService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CourseManagementMVCPortletKeys.COURSEMANAGEMENTMVC,
		"mvc.command.name=" + MVCCommandNames.EDIT_COURSE }, service = MVCRenderCommand.class)
public class EditCourseMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		Course course = null;
		String view = null;
		long courseId = ParamUtil.getLong(renderRequest, "courseId");

		try {

			course = _courseService.getCourse(courseId);
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
			portletDisplay.setShowBackIcon(true);
			String redirect = renderRequest.getParameter("redirect");
			portletDisplay.setURLBack(redirect);
			renderRequest.setAttribute("course", course);
			renderRequest.setAttribute("courseClass", Course.class);
			view = "/course/edit_course.jsp";
		} catch (NoSuchCourseException nsae) {

			renderRequest.setAttribute("error", nsae.getMessage());
			view = "/error.jsp";
			_log.error(nsae);
		} catch (PortalException pe) {

			_log.error(pe);
			renderRequest.setAttribute("error", pe.getMessage());
			view = "/error.jsp";
		} finally {

			return view;
		}
	}

	@Reference
	private CourseService _courseService;

	private static Log _log = LogFactoryUtil.getLog(EditCourseMVCRenderCommand.class.getClass());
}
