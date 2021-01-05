package com.liferay.course.web.portlet.action;

import com.liferay.course.model.Course;
import com.liferay.course.service.CourseService;
import com.liferay.course.web.constants.CoursePortletKeys;
import com.liferay.course.web.constants.MVCCommandNames;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=" + CoursePortletKeys.COURSE,
		"mvc.command.name=" + MVCCommandNames.VIEW_COURSE }, service = MVCRenderCommand.class)
public class ViewSingleCourseMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long courseId = ParamUtil.getLong(renderRequest, "courseId", 0);

		try {

			// Call the service to get the course.

			Course course = _courseService.getCourse(courseId);

			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("EEEEE, MMMMM dd, yyyy",
					renderRequest.getLocale());

			// Set attributes to the request.

			renderRequest.setAttribute("course", course);
			renderRequest.setAttribute("createDate", dateFormat.format(course.getCreateDate()));

			// Set back icon visible.

			PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

			String redirect = renderRequest.getParameter("redirect");

			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(redirect);

			return "/course/view_course.jsp";

		} catch (PortalException pe) {
			throw new PortletException(pe);
		}
	}

	@Reference
	private CourseService _courseService;

	@Reference
	private Portal _portal;

	@Reference
	private UserLocalService _userLocalService;
}